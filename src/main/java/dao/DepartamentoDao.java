package dao;

import entidad.Departamento;

import java.sql.SQLException;
import java.util.List;

public interface DepartamentoDao<D> {

    List<Departamento> selectAllDepartamento() throws SQLException;

    Departamento selectDepartmentsById(int id) throws SQLException;

    Departamento insertDepartamento(Departamento departamento) throws SQLException;

    Departamento deleteDepartamento(Departamento departamento) throws SQLException;

    Departamento updateDepartamento(Departamento departamento) throws SQLException;

}
