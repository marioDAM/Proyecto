package dao;

import entidad.Asignacion;

import java.sql.SQLException;
import java.util.List;

public interface AsignacionDao {
    List<Asignacion> selectAllAsignaciones() throws SQLException;
    Asignacion selectAsignacionPorId(int id) throws SQLException;
    Asignacion insertAsignacion(Asignacion asignacion) throws SQLException;
    Asignacion deleteAsignacion(Asignacion asignacion) throws SQLException;
    Asignacion updateAsignacion(Asignacion asignacion) throws SQLException;

}
