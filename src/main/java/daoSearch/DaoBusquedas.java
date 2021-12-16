package daoSearch;

import dao.ProyectoDao;
import daoImpl.ProyectoDaoImpl;
import database.ConnectionPool;
import entidad.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class DaoBusquedas {

    public List<Programador> programmersDepartmentId(int departamento) throws SQLException {
        String query = "select * from programador where idDepartamento = ?";
        ConnectionPool db = ConnectionPool.getInstance();
        List<Programador> programadores = new ArrayList<>();
        try {
            db.open();
            ResultSet result = db.select(query, departamento).orElseThrow(() -> new SQLException("Error al consultar registro de departamentos "));

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

    public void mostrarProgramadoresDadoDepartamento(int departamento) throws SQLException {
        List<Programador> programadores = programmersDepartmentId(departamento);

        System.out.println("Listado de programadores del departamento: " + departamento);
        for (Programador programador : programadores) {
            System.out.println(programador.toString());
        }

        System.out.println("");
    }

    public List<Proyecto> mostrarProyectosDepartamento(int departamento) throws SQLException {

        String query = ("SELECT py.* FROM proyecto py \n" +
                "INNER JOIN asignacion a ON a.idProyecto = py.idProyecto \n" +
                "INNER JOIN programador p ON a.idProgramador = p.idProgramadores \n" +
                "WHERE p.idDepartamento = ? \n" +
                "GROUP BY py.idProyecto; ");

        ConnectionPool db = ConnectionPool.getInstance();
        List<Proyecto> proyectos = new ArrayList<>();

        try {
            db.open();
            ResultSet result = db.select(query, departamento).orElseThrow(() -> new SQLException("Error al consultar registro de proyectos "));
            while (result.next()) {
                proyectos.add(new Proyecto(result.getInt("idProyecto"),
                        result.getString("nombre"),
                        result.getInt("idJefeProyecto"),
                        result.getDouble("presupuesto"),
                        result.getString("fechaInicio"),
                        result.getString("fechaFin"),
                        result.getString("tecnologias"),
                        result.getInt("idRepositorio")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();
        return proyectos;
    }

    public void mostrarProyectosDadoDepartamento(int departamento) throws SQLException {
        List<Proyecto> proyectos = mostrarProyectosDepartamento(departamento);
        System.out.println("Listado de proyectos del departamento: " + departamento);
        for (Proyecto proyecto : proyectos) {
            System.out.println(proyecto.toString());
        }
        System.out.println("");
    }

    public HashMap<String, Issues> listadoIssuesAbiertas() throws SQLException {

        String query = "SELECT p2.nombre, i.* FROM issues i \n" +
                "INNER JOIN programadorIssue pi ON pi.idIssue = i.idIssue \n" +
                "INNER JOIN programador p ON p.idProgramadores = pi.idProgramador \n" +
                "INNER JOIN asignacion a ON a.idProgramador = p.idProgramadores \n" +
                "INNER JOIN proyecto p2 ON p2.idProyecto = a.idProyecto \n" +
                "WHERE i.estado = 0";

        ConnectionPool db = ConnectionPool.getInstance();
        HashMap<String, Issues> issues = new HashMap<>();

        try {
            db.open();
            ResultSet result = db.select(query).orElseThrow(() -> new SQLException("Error al consultar listado de Issues por proyectos "));
            while (result.next()) {

                String nombreProyecto = result.getString("nombre");

                Issues i = new Issues(result.getInt("idIssue"),
                        result.getString("titulo"),
                        result.getString("texto"),
                        result.getString("fecha"),
                        result.getBoolean("estado"));

                issues.put(nombreProyecto, i);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();
        return issues;
    }

    public void mostrarIssuesAbiertas() throws SQLException {
        HashMap<String, Issues> issues = listadoIssuesAbiertas();

        System.out.println("Listado de issues abiertas por proyecto: ");

        for (Map.Entry<String, Issues> entrada : issues.entrySet()) {
            System.out.println("Proyecto=" + entrada.getKey() + "," + entrada.getValue().toString());
        }

        System.out.println("");
    }


    public HashMap<Integer, String> mostrarProyectosCommitsIssuesProgramador(int programador_id) throws SQLException {

        String query = "SELECT p.nombre as nombreProyecto ,c.*,i.* from commits c \n" +
                "INNER JOIN programadorIssue pi ON pi.idProgramadorIssue = c.idProgramadorIssue\n" +
                "INNER JOIN issues i ON i.idIssue = pi.idIssue \n" +
                "INNER JOIN asignacion a ON a.idProgramador = pi.idProgramador \n" +
                "INNER JOIN proyecto p ON p.idProyecto = a.idProyecto \n" +
                "WHERE pi.idProgramador = ? \n" +
                "ORDER BY p.idProyecto ASC";

        ConnectionPool db = ConnectionPool.getInstance();
        HashMap<Integer, String> informacion = new HashMap<>();

        try {
            db.open();
            ResultSet result = db.select(query, programador_id).orElseThrow(() -> new SQLException("Error al consultar registro de proyectos "));
            while (result.next()) {


                int id_programador = programador_id;
                String nombreProyecto = result.getString("nombreProyecto");
                Commits c = new Commits(
                        result.getInt("idCommit"),
                        result.getString("titulo"),
                        result.getString("texto"),
                        result.getString("fecha"),
                        result.getInt("idProgramadorIssue"));

                Issues i = new Issues(result.getInt("idIssue"),
                        result.getString("titulo"),
                        result.getString("texto"),
                        result.getString("fecha"),
                        result.getBoolean("estado"));

                String cadena = "Proyecto: " + nombreProyecto + " " + c.toString() + " " + i.toString();

                informacion.put(id_programador, cadena);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();
        return informacion;
    }


    public void mostrarProyectosCommitsIssuesDadoProgramador() throws SQLException {
        System.out.println("Entre el ID del programador a mostrar su información completa");
        Scanner teclado = new Scanner(System.in);
        int id = teclado.nextInt();

        HashMap<Integer, String> informacion = mostrarProyectosCommitsIssuesProgramador(id);

        System.out.println("Listado proyectos, commits e issues del programador: " + id);

        for (Map.Entry<Integer, String> entrada : informacion.entrySet()) {
            System.out.println("Programador=" + entrada.getKey() + " " + entrada.getValue());
        }

    }


}
