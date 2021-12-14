package dto;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entidad.Commits;
import entidad.Issues;
import entidad.Proyecto;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data

public class RepositorioDTO {
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

    private int idRepositorio;
    private Proyecto proyecto;
    private String nombre;
    private Date fechaCreacion;

    public RepositorioDTO(int idRepositorio, Proyecto proyecto, String nombre, Date fechaCreacion) {
        this.idRepositorio = idRepositorio;
        this.proyecto = proyecto;
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
    }

    public static RepositorioDTO fromJSON(String json) {
        final Gson gson = new Gson();
        return gson.fromJson(json, RepositorioDTO.class);
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
