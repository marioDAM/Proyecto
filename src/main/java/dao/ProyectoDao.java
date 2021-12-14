package dao;

import entidad.Proyecto;

import java.sql.SQLException;
import java.util.List;

public interface ProyectoDao<D> {

    List<Proyecto> selectAllProjects() throws SQLException;
    Proyecto selectById(int id) throws SQLException;
    Proyecto insertProyect(Proyecto proyecto) throws SQLException;

    Proyecto updateProyect(Proyecto proyecto) throws SQLException;
    Proyecto deleteProyecto(Proyecto proyecto) throws SQLException;




}
