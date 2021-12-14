package daoImpl;

import dao.AsignacionDao;
import database.ConnectionPool;
import entidad.Asignacion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AsignacionDaoImpl implements AsignacionDao {
    @Override
    public List<Asignacion> selectAllAsignaciones() throws SQLException {
        String query = "select * from asignacion";
        ConnectionPool db = ConnectionPool.getInstance();
        List<Asignacion> asignaciones=new ArrayList<>();
        try{
            db.open();
            ResultSet result= db.select(query).orElseThrow(() -> new SQLException("Error al consultar registro de Asignaciones "));

            while (result.next()){
                asignaciones.add(new Asignacion(
                        result.getInt("idAsignacion"),
                        result.getString("fechaAsignacion"),
                        result.getInt("idProyecto"),
                        result.getInt("idProgramador")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();
        return asignaciones;
    }

    @Override
    public Asignacion selectAsignacionPorId(int id) throws SQLException {
        String query = "select * from asignacion where idAsignacion =? ";
        ConnectionPool db = ConnectionPool.getInstance();

        db.open();
        ResultSet result = db.select(query,id).orElseThrow(() ->new SQLException("Error al consultar la Asignacion con id "+id));
        if(result.next()){
            Asignacion asignacion= new Asignacion(
                    result.getInt("idAsignacion"),
                    result.getString("fechaAsignacion"),
                    result.getInt("idProyecto"),
                    result.getInt("idProgramador")
            );
            db.close();
            return asignacion;
        }else
            throw new SQLException("No existe la Asignacion con ID: " + id);

    }

    @Override
    public Asignacion insertAsignacion(Asignacion asignacion) throws SQLException {
        String query = ("Insert into asignacion values (null,?,?,?)");
        ConnectionPool db = ConnectionPool.getInstance();
        db.open();

        ResultSet result=db.insert(query,asignacion.getFechaAsignacion(),asignacion.getIdProyecto(),asignacion.getIdProgramador()).
                orElseThrow(() -> new SQLException("Error al insertar la Asignacion"));

        if(result.next()){
            db.close();
            return asignacion;
        }else throw new SQLException("Error Asignacion al insertar en BD");

    }

    @Override
    public Asignacion deleteAsignacion(Asignacion asignacion) throws SQLException {
        String query = "DELETE FROM asignacion WHERE idAsignacion  = ?";
        ConnectionPool db = ConnectionPool.getInstance();
        db.open();
        int res= db.delete(query,asignacion.getIdAsignacion());
        db.close();
        if (res > 0)
            return asignacion;
        throw new SQLException("Error al borrar la asignacion con id: " + asignacion.getIdAsignacion());
    }

    @Override
    public Asignacion updateAsignacion(Asignacion asignacion) throws SQLException {
        String query = "UPDATE asignacion SET fechaAsignacion = ?, idProyecto = ?, idProgramador = ?  WHERE idAsignacion = ?";
        ConnectionPool db = ConnectionPool.getInstance();
        db.open();
        int res=db.update(query,asignacion.getFechaAsignacion(),asignacion.getIdProyecto(),asignacion.getIdProgramador(),asignacion.getIdAsignacion());
        db.close();
        if (res > 0)
            return asignacion;
        throw new SQLException("Error al actualizar la asignacion con id: " + asignacion.getIdAsignacion());
    }


}
