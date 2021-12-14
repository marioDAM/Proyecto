package controller;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dto.ProyectoDTO;


import java.sql.SQLException;

//public class ProyectoController {
//    private static ProyectoController controller = null;
//    // Mi Servicio unido al repositorio
//
//    private final ProyectoServicioDTO dpdto;
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
//    private ProyectoController(ProyectoServicioDTO proyectoService) {
//        this.dpdto = proyectoService;
//    }
//
//
//
//    public static ProyectoController getInstance() {
//        if (controller == null) {
//            controller = new ProyectoController(new ProyectoServicioDTO(new ProyectoDaoImpl()));
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
//    public String getAllProyectsJSON() {
//        // Vamos a devolver el JSON de las categorías
//        try {
//            final Gson prettyGson = new GsonBuilder()
//                    .addSerializationExclusionStrategy(strategy)
//                    .setPrettyPrinting()
//                    .create();
//            return prettyGson.toJson(dpdto.getAllProyects());
//        } catch (SQLException e) {
//            System.err.println("Error UserController en getAllUser: " + e.getMessage());
//            return "Error UserController en getAllUser: " + e.getMessage();
//        }
//    }
//
//    public String getProyectByIdJSON(int id) {
//        // Vamos a devolver el JSON de las categorías
//        try {
//            final Gson prettyGson = new GsonBuilder()
//                    .addSerializationExclusionStrategy(strategy)
//                    .setPrettyPrinting()
//                    .create();
//            return prettyGson.toJson(dpdto.getProyectById(id));
//        } catch (SQLException e) {
//            System.err.println("Error UserController en getUserById " + e.getMessage());
//            return "Error UserController en getUserById: " + e.getMessage();
//        }
//    }
//
//    public String postProyectoJSON(ProyectoDTO proyectoDTO) {
//        try {
//            final Gson prettyGson = new GsonBuilder()
//                    .addSerializationExclusionStrategy(strategy)
//                    .setPrettyPrinting()
//                    .create();
//            return prettyGson.toJson(dpdto.postProyect(proyectoDTO));
//        } catch (SQLException e) {
//            System.err.println("Error UserController en postUser " + e.getMessage());
//            return "Error UserController en postUser: " + e.getMessage();
//        }
//    }
//
//    public String updateProyectJSON(ProyectoDTO proyectoDTO) {
//        try {
//            final Gson prettyGson = new GsonBuilder()
//                    .addSerializationExclusionStrategy(strategy)
//                    .setPrettyPrinting()
//                    .create();
//            return prettyGson.toJson(dpdto.updateProyect(proyectoDTO));
//        } catch (SQLException e) {
//            System.err.println("Error UserController en updateUser " + e.getMessage());
//            return "Error UserController en updateUser: " + e.getMessage();
//        }
//    }
//
//    public String deleteProyectJSON(ProyectoDTO proyectoDTO) {
//        try {
//            final Gson prettyGson = new GsonBuilder()
//                    .addSerializationExclusionStrategy(strategy)
//                    .setPrettyPrinting()
//                    .create();
//            return prettyGson.toJson(dpdto.deleteProyect(proyectoDTO));
//        } catch (SQLException e) {
//            System.err.println("Error UserController en deleteUser " + e.getMessage());
//            return "Error UserController en deleteUser: " + e.getMessage();
//        }
//    }
//}
