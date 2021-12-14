package daoSearch;

import dao.ProyectoDao;
import daoImpl.ProyectoDaoImpl;
import database.ConnectionPool;
import entidad.Asignacion;
import entidad.Issues;
import entidad.Programador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoBusquedas {

    public List<Asignacion> busqueda1() throws SQLException {
        String query = "select * FROM asignacion WHERE idProgramador  is (SELECT idProgramador FROM programador where idDepartamento is ?)\n";
        List<Asignacion> asignaciones = new ArrayList<>();
        ConnectionPool db = ConnectionPool.getInstance();
        Asignacion asignacion;
        try {
            db.open();
            ResultSet result = db.select(query).orElseThrow(() -> new SQLException("Error al consultar la lista de commits "));
            while (result.next()) {
                asignaciones.add(new Asignacion(result.getInt("idAsignacion"), result.getString("fechaAsignacion"), result.getInt("idProyecto"), result.getInt("idProgramador")));
            }
            ProyectoDao pd = new ProyectoDaoImpl();
            //pd.selectById(asignaciones.get)
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        db.close();
        return asignaciones;
    }

    public List<Issues> busqueda2() throws SQLException {
        String query = "SELECT* FROM issues i WHERE estado is 0";
        ConnectionPool db = ConnectionPool.getInstance();
        List<Issues> issue = new ArrayList<>();
        try {
            db.open();
            ResultSet result = db.select(query).orElseThrow(() ->
                    new SQLException("Error al consultar el registro de Issues"));

            while (result.next()) {
                issue.add(new Issues(
                        result.getInt("idIssue"),
                        result.getString("titulo"),
                        result.getString("texto"),
                        result.getString("fecha"),
                        result.getBoolean("estado")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();
        return issue;
    }

    public List<Programador> busqueda3(int id) throws SQLException {
        String query = "SELECT * FROM programador WHERE idProgramadores is(SELECT idProgramador FROM asignacion WHERE idProyecto is ?)";

        ConnectionPool db = ConnectionPool.getInstance();
        List<Programador> programadores = new ArrayList<>();
        try {
            db.open();
            ResultSet result = db.select(query, id).orElseThrow(() -> new SQLException("Error al consultar registro de departamentos "));

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
}
