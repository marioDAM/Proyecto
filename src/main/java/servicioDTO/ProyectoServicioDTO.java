package servicioDTO;
import java.sql.SQLException;
import java.util.List;

//public class ProyectoServicioDTO extends BaseServiceProyecto<Proyecto> {
//    ProyectoMapper mapper = new ProyectoMapper();
//
//    public ProyectoServicioDTO(ProyectoDaoImpl repository) {
//        super(repository);
//    }
//
//    public List<ProyectoDTO> getAllProyects() throws SQLException {
//        return mapper.toDTO(this.findAll());
//    }
//
//    public ProyectoDTO getProyectById(int id) throws SQLException {
//        return mapper.toDTO(this.getById(id));
//    }
//
//    public ProyectoDTO postProyect(ProyectoDTO proyectoServicioDTO) throws SQLException {
//        // Ciframos antes el password
//        Proyecto proyecto = this.save(mapper.fromDTO(proyectoServicioDTO));
//        return mapper.toDTO(proyecto);
//    }
//
//    public ProyectoDTO updateProyect(ProyectoDTO userDTO) throws SQLException {
//        Proyecto proyecto = this.update(mapper.fromDTO(userDTO));
//        return mapper.toDTO(proyecto);
//    }
//
//    public ProyectoDTO deleteProyect(ProyectoDTO userDTO) throws SQLException {
//        Proyecto proyecto = this.delete(mapper.fromDTO(userDTO));
//        return mapper.toDTO(proyecto);
//    }
//}
