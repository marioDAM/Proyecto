

import database.ConnectionPool;
import dto.DepartamentoDTO;
import dto.ProyectoDTO;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.Optional;

public class BdSqlite {

    private static BdSqlite instance;

    BdSqlite() {
    }

    public static BdSqlite getInstance() {
        if (instance == null) {
            instance = new BdSqlite();
        }
        return instance;
    }

    static void checkServer() {

        System.out.println("Comprobamos la conexión al Servidor BD");
        ConnectionPool controller = ConnectionPool.getInstance();
        try {
            controller.open();
            Optional<ResultSet> rs = controller.select("SELECT 'Hello world'");
            if (rs.isPresent()) {
                rs.get().next();
                controller.close();
                System.out.println("Conexión correcta");
            }
        } catch (SQLException e) {
            System.err.println("Error al conectar al servidor de Base de Datos: " + e.getMessage());
            System.exit(1);
        }
    }

    public void initData() {
        System.out.println("Iniciamos los datos");
        ConnectionPool controller = ConnectionPool.getInstance();
        String sqlFile = System.getProperty("user.dir") + File.separator + "sql" + File.separator + "proyecto.sql";
        System.out.println(sqlFile);
        try {
            controller.open();
            controller.initData(sqlFile);
            controller.close();
        } catch (SQLException e) {
            System.err.println("Error al conectar al servidor de Base de Datos: " + e.getMessage());
            System.exit(1);
        } catch (FileNotFoundException e) {
            System.err.println("Error al leer el fichero de datos iniciales: " + e.getMessage());
            System.exit(1);
        }
    }

//    public void Departamento() {
//        DepartamentoController controller = DepartamentoController.getInstance();
//
//        System.out.println("GET Todos los departamentos");
//        System.out.println(controller.getAllDepartmentsJSON());
//
//        System.out.println("GET Departamento con ID = 2");
//        System.out.println(controller.getDepartmentByIdJSON(2));
//
//        System.out.println("Post Insertando Departamento");
//        DepartamentoDTO userDTO = DepartamentoDTO.builder()
//                .nombre("Nombre " + Instant.now().toString())
//                .build();
//        System.out.println(controller.postDepartmentJSON(userDTO));
//
//        System.out.println("UPDATE departamento con ID = 5");
//        userDTO = DepartamentoDTO.builder()
//                .idDepartamento(4)
//                .nombre("Prueba Update")
//                .build();
//        System.out.println(controller.updateDepartmentJSON(userDTO));
//
//        System.out.println("DELETE Departamento con ID = 5");
//        userDTO = DepartamentoDTO.builder()
//                .idDepartamento(5)
//                .build();
//        System.out.println(controller.deleteDepartmentJSON(userDTO));
//    }
//
//    public void Proyecto() {
//        ProyectoController controller = ProyectoController.getInstance();
//
//        System.out.println("GET Todos los proyecto");
//        System.out.println(controller.getAllProyectsJSON());
//
//        System.out.println("GET proyecto con ID = 2");
//        System.out.println(controller.getProyectByIdJSON(2));
//
//        System.out.println("Post Insertando proyecto");
//        ProyectoDTO userDTO = ProyectoDTO.builder()
//                .nombre("Nombre " + Instant.now().toString())
//                .build();
//        System.out.println(controller.postProyectoJSON(userDTO));
//
//        System.out.println("UPDATE departamento con ID = 5");
//        userDTO = ProyectoDTO.builder()
//                .idProyecto(4)
//                .nombre("Prueba Update")
//                .build();
//        System.out.println(controller.updateProyectJSON(userDTO));
//
//        System.out.println("DELETE Departamento con ID = 5");
//        userDTO = ProyectoDTO.builder()
//                .idProyecto(5)
//                .build();
//        System.out.println(controller.deleteProyectJSON(userDTO));
//
//    }
}
