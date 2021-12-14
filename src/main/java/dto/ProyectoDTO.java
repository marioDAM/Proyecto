package dto;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entidad.Asignacion;
import entidad.Departamento;
import entidad.Programador;
import entidad.Repositorio;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ProyectoDTO {
    ExclusionStrategy strategy = new ExclusionStrategy() {
        @Override
        public boolean shouldSkipClass(Class<?> clazz) {
            return false;
        }

        @Override
        public boolean shouldSkipField(FieldAttributes field) {
            return field.getName().startsWith("password");
        }
    };

    private int idProyecto;
    private String nombre;
    private int idJefeProyecto;
    private double presupuesto;
    private String fechaInicio;
    private String fechaFin;
    private String tecnologias;
    private int repositorio;

    public ProyectoDTO(ExclusionStrategy strategy, int idProyecto, String nombre, int idJefeProyecto, double presupuesto, String fechaInicio, String fechaFin,
                       String tecnologias, int repositorio) {
        this.strategy = strategy;
        this.idProyecto = idProyecto;
        this.nombre = nombre;
        this.idJefeProyecto = idJefeProyecto;
        this.presupuesto = presupuesto;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.tecnologias = tecnologias;
        this.repositorio = repositorio;
    }

    public static ProyectoDTO fromJSON(String json) {
        final Gson gson = new Gson();
        return gson.fromJson(json, ProyectoDTO.class);
    }

    public String toJSON() {
        final Gson prettyGson = new GsonBuilder()
                // .excludeFieldsWithoutExposeAnnotation() // Quitamos los campos que no están expuestos y evitamos lo anterior
                .addSerializationExclusionStrategy(strategy)
                .setPrettyPrinting()
                .create();
        // Otra manera de quitar un campo determinado para imprimir
        // prettyGson.toJsonTree(this).getAsJsonObject().remove("password");
        return prettyGson.toJson(this);
    }
}
