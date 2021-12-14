package dto;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entidad.Commits;
import entidad.Programador;
import entidad.Proyecto;
import entidad.Repositorio;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data

public class IssuesDTO {
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

    private int idIssue;
    private String titulo;
    private String texto;
    private Date fecha;
    private boolean estado;
    private ArrayList<Programador> programadores;

    public IssuesDTO(int idIssue, String titulo, String texto, Date fecha, boolean estado) {
        this.idIssue = idIssue;
        this.titulo = titulo;
        this.texto = texto;
        this.fecha = fecha;
        this.estado = estado;
        this.programadores = new ArrayList<>();
    }

    public static IssuesDTO fromJSON(String json) {
        final Gson gson = new Gson();
        return gson.fromJson(json, IssuesDTO.class);
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
