package dto;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entidad.Commits;
import entidad.Departamento;
import entidad.Issues;
import entidad.Proyecto;
import lombok.Builder;
import lombok.Data;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class ProgramadorDTO {
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

    private int idProgramadores;
    private String nombre;
    private String fechaAlta;
    private List<String> tecnologias;
    private double salario;
    private String password;
    private boolean esJefe;
    private Departamento departamento;
    private ArrayList<Commits> commits;
    private ArrayList<Issues> issues;


    public ProgramadorDTO(int idProgramadores, String nombre, String fechaAlta, List<String> tecnologias, double salario, String password, boolean esJefe, Departamento departamento) {
        this.idProgramadores = idProgramadores;
        this.nombre = nombre;
        this.fechaAlta = fechaAlta;
        this.tecnologias = tecnologias;
        this.salario = salario;
        this.password = password;
        this.esJefe = esJefe;
        this.departamento = departamento;
        this.commits = new ArrayList<>();
        this.issues = new ArrayList<>();
    }

    public static ProgramadorDTO fromJSON(String json) {
        final Gson gson = new Gson();
        return gson.fromJson(json, (Type) ProyectoDTO.class);
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
