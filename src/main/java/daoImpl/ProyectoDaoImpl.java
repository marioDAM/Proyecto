package daoImpl;
import dao.ProyectoDao;
import database.ConnectionPool;
import entidad.Proyecto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProyectoDaoImpl implements ProyectoDao {
    @Override
    public List<Proyecto> selectAllProjects() throws SQLException {
        String query = ("select * from proyecto");
        ConnectionPool db = ConnectionPool.getInstance();
        List<Proyecto> proyectos = new ArrayList<>();

        try {
            db.open();
            ResultSet result = db.select(query).orElseThrow(() -> new SQLException("Error al consultar registro de proyectos "));
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

    @Override
    public Proyecto selectById(int id) throws SQLException {
        String query = "Select * from proyecto where idProyecto =?";
        ConnectionPool db = ConnectionPool.getInstance();
        db.open();
        ResultSet result = db.select(query, id).orElseThrow(() -> new SQLException("Error al consultar registro de proyectos"));
        Proyecto proyecto;

        if (result.next()) {
            proyecto = new Proyecto(result.getInt("idProyecto"),
                    result.getString("nombre"),
                    result.getInt("idJefeProyecto"),
                    result.getDouble("presupuesto"),
                    result.getString("fechaInicio"),
                    result.getString("fechaFin"),
                    result.getString("tecnologias"),
                    result.getInt("idRepositorio"));


            return proyecto;
        } else
            throw new SQLException("Error no existe Proyecto con ID: " + id);
    }

    @Override
    public Proyecto insertProyect(Proyecto proyecto) throws SQLException {
        String query = "INSERT INTO proyecto values (null,?,?,?,?,?,?,?)";
        ConnectionPool db = ConnectionPool.getInstance();
        db.open();

        ResultSet result = db.insert(query, proyecto.getNombre(), proyecto.getIdJefeProyecto(),
                proyecto.getPresupuesto(), proyecto.getFechaInicio(), proyecto.getFechaFin(), proyecto.getTecnologias(),
                proyecto.getRepositorio()).orElseThrow(()
                -> new SQLException("Error al insertar registro de proyectos "));
        if (result.next()) {
            db.close();
            return proyecto;
        } else
            throw new SQLException("Error ProyectoDAO al insertar proyecto en BD");
    }

    @Override

    public Proyecto updateProyect(Proyecto proyecto) throws SQLException {
        String query = "UPDATE proyecto SET nombre = ?, idJefeProyecto = ?, presupuesto=?, fechaInicio=?," +
                " fechaFin=?, tecnologias=?, idRepositorio =? WHERE idProyecto = ?";
        ConnectionPool db = ConnectionPool.getInstance();
        db.open();
        int res = db.update(query,
                proyecto.getNombre(),
                proyecto.getIdJefeProyecto(),
                proyecto.getPresupuesto(),
                proyecto.getFechaInicio(),
                proyecto.getFechaFin(),
                proyecto.getTecnologias(),
                proyecto.getRepositorio());
        db.close();
        if (res > 0)
            return proyecto;
        else
            throw new SQLException("Error al actualizar el Proyecto con id: " + proyecto.getIdProyecto());
    }

    @Override
    public Proyecto deleteProyecto(Proyecto proyecto) throws SQLException {
        String query = "DELETE FROM proyecto WHERE idProyecto = ?";
        ConnectionPool db = ConnectionPool.getInstance();
        db.open();
        int res = db.delete(query, proyecto.getIdProyecto());
        db.close();
        if (res > 0)
            return proyecto;
        throw new SQLException("Error al borrar el proyecto con id: " + proyecto.getIdProyecto());

    }
}
