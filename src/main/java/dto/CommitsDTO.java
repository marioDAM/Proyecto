package dto;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entidad.*;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
public class CommitsDTO {
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
    private int idCommit;
    private String titulo;
    private String texto;
    private Date fecha;
    private ProgramadorIssue asignacionPI;

    public CommitsDTO(int idCommit, String titulo, String texto, Date fecha, ProgramadorIssue pi) {
        this.idCommit = idCommit;
        this.titulo = titulo;
        this.texto = texto;
        this.fecha = fecha;
        this.asignacionPI = pi;
    }

    public static CommitsDTO fromJSON(String json) {
        final Gson gson = new Gson();
        return gson.fromJson(json, CommitsDTO.class);
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
