package daoImpl;

import dao.ProgramadorDao;
import database.ConnectionPool;
import entidad.Programador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProgramadorDaoImpl implements ProgramadorDao {

    @Override
    public List<Programador> selectAllProgrammers() throws SQLException {
        String query = "select * from programador";

        ConnectionPool db = ConnectionPool.getInstance();
        List<Programador> programadores = new ArrayList<>();
        try {
            db.open();
            ResultSet result = db.select(query).orElseThrow(() -> new SQLException("Error al consultar registro de departamentos "));

            while (result.next()) {
                programadores.add(new Programador(
                        result.getInt("idProgramadores"),
                        result.getString("nombre"),
                        result.getString("fechaAlta"),
                        result.getString("tecnologias"),
                        result.getDouble("salario"),
                        result.getString("password"),
                        result.getBoolean("esJefe"),
                        result.getInt("idDepartamento")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();
        return programadores;
    }

    @Override
    public Programador selectProgrammerById(int id) throws SQLException {
        String query = "select * from programador where idProgramadores =? ";

        ConnectionPool db = ConnectionPool.getInstance();

        db.open();

        ResultSet result = db.select(query, id).orElseThrow(() ->
                new SQLException("Error al consultar programador con ID " + id));
        if (result.next()) {

            Programador programador = new Programador(
                    result.getInt("idProgramadores"),
                    result.getString("nombre"),
                    result.getString("fechaAlta"),
                    result.getString("tecnologias"),
                    result.getDouble("salario"),
                    result.getString("password"),
                    result.getBoolean("esJefe"),
                    result.getInt("idDepartamento")
            );
            db.close();
            return programador;


        } else
            throw new SQLException("Error no existe Programador con ID: " + id);


    }

    @Override
    public Programador insertProgrammer(Programador programador) throws SQLException {
        String query = ("Insert into programador values (null,?,?,?,?,?,?,?)");
        ConnectionPool db = ConnectionPool.getInstance();
        db.open();

        System.out.println("PROGRAMADOR: " +programador.toString());

        ResultSet result = db.insert(query,
                programador.getNombre(),
                programador.getFechaAlta(),
                programador.getTecnologias(),
                programador.getSalario(),
                programador.getPassword(),
                programador.isEsJefe(),
                programador.getDepartamento()
        ).orElseThrow(() -> new SQLException("Error ProgramadorRepository al insertar programador"));

        if (result.next()) {
            db.close();
            return programador;
        } else
            throw new SQLException("Error ProgramadorDAO al insertar Programador en BD");
    }


    @Override
    public Programador deleteProgrammer(Programador programador) throws SQLException {
        String query = ("DELETE FROM programador WHERE idProgramadores  = ?");
        ConnectionPool db = ConnectionPool.getInstance();
        db.open();
        int res = db.delete(query, programador.getIdProgramadores());
        db.close();
        if (res > 0)
            return programador;
        throw new SQLException("Error ProgramadorRepository al borrar Programador con id: " + programador.getIdProgramadores());
    }

    @Override
    public Programador updateProgrammer(Programador programador) throws SQLException {
        String query = "UPDATE programador SET nombre = ?, fechaAlta = ?, tecnologias =?," +
                "salario =?, password=?,esJefe=?, idDepartamento =? WHERE idProgramadores = ?";
        ConnectionPool db = ConnectionPool.getInstance();
        db.open();
        int res = db.update(query,
                programador.getNombre(),
                programador.getFechaAlta(),
                programador.getTecnologias(),
                programador.getSalario(),
                programador.getPassword(),
                programador.isEsJefe(),
                programador.getDepartamento());
        db.close();
        if (res > 0)
            return programador;
        else
            throw new SQLException("Error ProgramadorRepository al actualizar Programador con id: " + programador.getIdProgramadores());
    }
}
