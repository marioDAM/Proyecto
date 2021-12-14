package controller;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import daoImpl.DepartamentoDaoImpl;
import dto.DepartamentoDTO;




import java.sql.SQLException;

//public class DepartamentoController {
//    private static DepartamentoController controller = null;
//    // Mi Servicio unido al repositorio
//
//    private final DepartamentoServiceDTO dpdto;
//    // Con esto evitamos que se imprima el campo password si no queremos
//
//    ExclusionStrategy strategy = new ExclusionStrategy() {
//        @Override
//        public boolean shouldSkipClass(Class<?> clazz) {
//            return false;
//        }
//
//        @Override
//        public boolean shouldSkipField(FieldAttributes field) {
//            return field.getName().startsWith("password");
//        }
//    };
//
//    // Implementamos nuestro Singleton para el controlador
//    private DepartamentoController(DepartamentoServiceDTO departamentoService) {
//        this.dpdto = departamentoService;
//    }
//
//
//    public static DepartamentoController getInstance() {
//        if (controller == null) {
//            controller = new DepartamentoController(new DepartamentoServiceDTO(new DepartamentoDaoImpl()));
//        }
//        return controller;
//    }
//
//    // Ejemplo de operaciones
//    // Usamos DTO para implementar este patrón en represantación y trasporte de la información
////    public List<UserDTO> getAllUsers() {
////        return userService.getAllUsers();
////    }
//
//    public String getAllDepartmentsJSON() {
//        // Vamos a devolver el JSON de las categorías
//        try {
//            final Gson prettyGson = new GsonBuilder()
//                    .addSerializationExclusionStrategy(strategy)
//                    .setPrettyPrinting()
//                    .create();
//            return prettyGson.toJson(dpdto.getAllUsers());
//        } catch (SQLException e) {
//            System.err.println("Error UserController en getAllUser: " + e.getMessage());
//            return "Error UserController en getAllUser: " + e.getMessage();
//        }
//    }
//
//    public String getDepartmentByIdJSON(int id) {
//        // Vamos a devolver el JSON de las categorías
//        try {
//            final Gson prettyGson = new GsonBuilder()
//                    .addSerializationExclusionStrategy(strategy)
//                    .setPrettyPrinting()
//                    .create();
//            return prettyGson.toJson(dpdto.getUserById(id));
//        } catch (SQLException e) {
//            System.err.println("Error UserController en getUserById " + e.getMessage());
//            return "Error UserController en getUserById: " + e.getMessage();
//        }
//    }
//
//    public String postDepartmentJSON(DepartamentoDTO departamentoDTO) {
//        try {
//            final Gson prettyGson = new GsonBuilder()
//                    .addSerializationExclusionStrategy(strategy)
//                    .setPrettyPrinting()
//                    .create();
//            return prettyGson.toJson(dpdto.postDepartment(departamentoDTO));
//        } catch (SQLException e) {
//            System.err.println("Error UserController en postUser " + e.getMessage());
//            return "Error UserController en postUser: " + e.getMessage();
//        }
//    }
//
//    public String updateDepartmentJSON(DepartamentoDTO departamentoDTO) {
//        try {
//            final Gson prettyGson = new GsonBuilder()
//                    .addSerializationExclusionStrategy(strategy)
//                    .setPrettyPrinting()
//                    .create();
//            return prettyGson.toJson(dpdto.updateUser(departamentoDTO));
//        } catch (SQLException e) {
//            System.err.println("Error UserController en updateUser " + e.getMessage());
//            return "Error UserController en updateUser: " + e.getMessage();
//        }
//    }
//
//    public String deleteDepartmentJSON(DepartamentoDTO departamentoDTO) {
//        try {
//            final Gson prettyGson = new GsonBuilder()
//                    .addSerializationExclusionStrategy(strategy)
//                    .setPrettyPrinting()
//                    .create();
//            return prettyGson.toJson(dpdto.deleteUser(departamentoDTO));
//        } catch (SQLException e) {
//            System.err.println("Error UserController en deleteUser " + e.getMessage());
//            return "Error UserController en deleteUser: " + e.getMessage();
//        }
//    }
//}
