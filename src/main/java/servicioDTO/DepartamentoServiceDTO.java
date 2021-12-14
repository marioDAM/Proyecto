package servicioDTO;


import daoImpl.DepartamentoDaoImpl;
import dto.DepartamentoDTO;
import entidad.Departamento;


import java.sql.SQLException;
import java.util.List;
//
//public class DepartamentoServiceDTO extends BaseServiceDepartamento<Departamento> {
//    DepartamentoMapper mapper = new DepartamentoMapper();
//
//    public DepartamentoServiceDTO(DepartamentoDaoImpl repository) {
//        super(repository);
//    }
//
//
//    public List<DepartamentoDTO> getAllUsers() throws SQLException {
//        return mapper.toDTO(this.findAll());
//    }
//
//    public DepartamentoDTO getUserById(int id) throws SQLException {
//        return mapper.toDTO(this.getById(id));
//    }
//
//    public DepartamentoDTO postDepartment(DepartamentoDTO departamentoDTO) throws SQLException {
//        // Ciframos antes el password
//        Departamento departamento = this.save(mapper.fromDTO(departamentoDTO));
//        return mapper.toDTO(departamento);
//    }
//
//    public DepartamentoDTO updateUser(DepartamentoDTO userDTO) throws SQLException {
//        Departamento departamento = this.update(mapper.fromDTO(userDTO));
//        return mapper.toDTO(departamento);
//    }
//
//    public DepartamentoDTO deleteUser(DepartamentoDTO userDTO) throws SQLException {
//        Departamento departamento = this.delete(mapper.fromDTO(userDTO));
//        return mapper.toDTO(departamento);
//    }
//
//}

