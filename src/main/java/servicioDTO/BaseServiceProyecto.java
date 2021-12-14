package servicioDTO;

import dao.CrudRespository;
import dao.DepartamentoDao;
import dao.ProyectoDao;
import daoImpl.DepartamentoDaoImpl;

import java.sql.SQLException;
import java.util.List;

//public class BaseServiceProyecto<Proyecto extends CrudRespository<Proyecto>> {
//
//    ProyectoDao da = new ProyectoDaoImpl();
//
//    public BaseServiceProyecto(ProyectoDaoImpl repository) {
//        this.da = repository;
//    }
//    // Operaciones CRUD
//
//    // Obtiene todos
//    public List<Proyecto> findAll() throws SQLException {
//        return (List<Proyecto>) da.selectAllProjects();
//    }
//
//    // Obtiene por ID
//    public Proyecto getById(int id) throws SQLException {
//        return (Proyecto) da.selectById(id);
//    }
//
//    // Salva
//    public Proyecto save(Proyecto t) throws SQLException {
//        return (Proyecto) da.insertProyect((entidad.Proyecto) t);
//    }
//
//    // Actualiza
//    public Proyecto update(Proyecto t) throws SQLException {
//        return (Proyecto) da.updateProyect((entidad.Proyecto) t);
//    }
//
//    // Elimina
//    public Proyecto delete(Proyecto t) throws SQLException {
//        return (Proyecto) da.deleteProyecto((entidad.Proyecto) t);
//    }
//}
