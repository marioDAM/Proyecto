package servicioDTO;

import dao.CrudRespository;
import dao.DepartamentoDao;
import daoImpl.DepartamentoDaoImpl;
import lombok.RequiredArgsConstructor;

import java.sql.SQLException;
import java.util.List;

@RequiredArgsConstructor // Requerimos un constructor con al menos las propiedades finales
public abstract class BaseServiceDepartamento<Departamento extends CrudRespository<Departamento>> {

    DepartamentoDao da = new DepartamentoDaoImpl();

    public BaseServiceDepartamento(DepartamentoDaoImpl repository) {
        this.da = repository;
    }
    // Operaciones CRUD

    // Obtiene todos
    public List<Departamento> findAll() throws SQLException {
        return (List<Departamento>) da.selectAllDepartamento();
    }

    // Obtiene por ID
    public Departamento getById(int id) throws SQLException {
        return (Departamento) da.selectDepartmentsById(id);
    }

    // Salva
    public Departamento save(Departamento t) throws SQLException {
        return (Departamento) da.insertDepartamento((entidad.Departamento) t);
    }

    // Actualiza
    public Departamento update(Departamento t) throws SQLException {
        return (Departamento) da.updateDepartamento((entidad.Departamento) t);
    }

    // Elimina
    public Departamento delete(Departamento t) throws SQLException {
        return (Departamento) da.deleteDepartamento((entidad.Departamento) t);
    }
}