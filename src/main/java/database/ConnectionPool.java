package database;

import lombok.NonNull;
import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.*;
import java.sql.*;
import java.util.Optional;

public class ConnectionPool {

    private static ConnectionPool controller;

    @NonNull
    private String jdbcDriver;

    // Para manejar las conexiones y respuestas de las mismas
    @NonNull
    private Connection connection;
    @NonNull
    private PreparedStatement preparedStatement;
    @NonNull
    private String DATABASE = System.getProperty("user.dir") + File.separator + "db" + File.separator + "proyectos.sqlite";

    /**
     * Devuelve una instancia del controlador
     *
     * @return instancia del controladorBD
     */
    public static ConnectionPool getInstance() {
        if (controller == null) {
            controller = new ConnectionPool();
        }
        return controller;
    }

    /**
     * Abre la conexión con el servidor  de base de datos
     *
     * @throws SQLException Servidor no accesible por problemas de conexión o datos de acceso incorrectos
     */
    public void open() throws SQLException {
        String url = "jdbc:sqlite:" + DATABASE;
        // Obtenemos la conexión
        connection = DriverManager.getConnection(url);
    }

    /**
     * Cierra la conexión con el servidor de base de datos
     *
     * @throws SQLException Servidor no responde o no puede realizar la operación de cierre
     */
    public void close() throws SQLException {
        preparedStatement.close();
        connection.close();
    }

    /**
     * Realiza una consulta a la base de datos de manera "preparada" obteniendo los parametros opcionales si son necesarios
     *
     * @param querySQL consulta SQL de tipo select
     * @param params   parámetros de la consulta parametrizada
     * @return ResultSet de la consulta
     * @throws SQLException No se ha podido realizar la consulta o la tabla no existe
     */
    private ResultSet executeQuery(@NonNull String querySQL, Object... params) throws SQLException {
        preparedStatement = connection.prepareStatement(querySQL);
        // Vamos a pasarle los parametros usando preparedStatement
        for (int i = 0; i < params.length; i++) {
            preparedStatement.setObject(i + 1, params[i]);
        }
        return preparedStatement.executeQuery();
    }

    /**
     * Realiza una consulta select a la base de datos de manera "preparada" obteniendo los parametros opcionales si son necesarios
     *
     * @param querySQL consulta SQL de tipo select
     * @param params   parámetros de la consulta parametrizada
     * @return ResultSet de la consulta
     * @throws SQLException No se ha podido realizar la consulta o la tabla no existe
     */
    public Optional<ResultSet> select(@NonNull String querySQL, Object... params) throws SQLException {
        return Optional.of(executeQuery(querySQL, params));
    }

    /**
     * Realiza una consulta select a la base de datos de manera "preparada" obteniendo los parametros opcionales si son necesarios
     *
     * @param querySQL consulta SQL de tipo select
     * @param limit    número de registros de la página
     * @param offset   desplazamiento de registros o número de registros ignorados para comenzar la devolución
     * @param params   parámetros de la consulta parametrizada
     * @return ResultSet de la consulta
     * @throws SQLException No se ha podido realizar la consulta o la tabla no existe o el desplazamiento es mayor que el número de registros
     */
    public Optional<ResultSet> select(@NonNull String querySQL, int limit, int offset, Object... params)
            throws SQLException {
        String query = querySQL + " LIMIT " + limit + " OFFSET " + offset;
        return Optional.of(executeQuery(query, params));
    }

    /**
     * Realiza una consulta de tipo insert de manera "preparada" con los parametros opcionales si son encesarios
     *
     * @param insertSQL consulta SQL de tipo insert
     * @param params    parámetros de la consulta parametrizada
     * @return Clave del registro insertado
     * @throws SQLException tabla no existe o no se ha podido realizar la operación
     */
    public Optional<ResultSet> insert(@NonNull String insertSQL, Object... params) throws SQLException {
        // Con return generated keys obtenemos las claves generadas is las claves es autonumerica por ejemplo
        preparedStatement = connection.prepareStatement(insertSQL, preparedStatement.RETURN_GENERATED_KEYS);
        // Vamos a pasarle los parametros usando preparedStatement
        for (int i = 0; i < params.length; i++) {
            preparedStatement.setObject(i + 1, params[i]);
        }
        preparedStatement.executeUpdate();
        return Optional.of(preparedStatement.getGeneratedKeys());
    }

    /**
     * Realiza una consulta de tipo update de manera "preparada" con los parametros opcionales si son encesarios
     *
     * @param updateSQL consulta SQL de tipo update
     * @param params    parámetros de la consulta parametrizada
     * @return número de registros actualizados
     * @throws SQLException tabla no existe o no se ha podido realizar la operación
     */
    public int update(@NonNull String updateSQL, Object... params) throws SQLException {
        return updateQuery(updateSQL, params);
    }

    /**
     * Realiza una consulta de tipo delete de manera "preparada" con los parametros opcionales si son encesarios
     *
     * @param deleteSQL consulta SQL de tipo delete
     * @param params    parámetros de la consulta parametrizada
     * @return número de registros eliminados
     * @throws SQLException tabla no existe o no se ha podido realizar la operación
     */
    public int delete(@NonNull String deleteSQL, Object... params) throws SQLException {
        return updateQuery(deleteSQL, params);
    }

    /**
     * Realiza una consulta de tipo update, es decir que modifca los datos, de manera "preparada" con los parametros opcionales si son encesarios
     *
     * @param genericSQL consulta SQL de tipo update, delete, creted, etc.. que modifica los datos
     * @param params     parámetros de la consulta parametrizada
     * @return número de registros eliminados
     * @throws SQLException tabla no existe o no se ha podido realizar la operación
     */
    private int updateQuery(@NonNull String genericSQL, Object... params) throws SQLException {
        // Con return generated keys obtenemos las claves generadas
        preparedStatement = connection.prepareStatement(genericSQL);
        // Vamos a pasarle los parametros usando preparedStatement
        for (int i = 0; i < params.length; i++) {
            preparedStatement.setObject(i + 1, params[i]);
        }
        return preparedStatement.executeUpdate();
    }

    public void initData(@NonNull String sqlFile) throws FileNotFoundException {
        ScriptRunner sr = new ScriptRunner(connection);
        sr.setEscapeProcessing(false); // Para SQLite
        Reader reader = new BufferedReader(new FileReader(sqlFile));
        sr.runScript(reader);
    }
}
