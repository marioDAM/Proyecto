package dto;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entidad.Programador;
import entidad.Proyecto;
import lombok.Data;

import java.util.ArrayList;


@Data
public class DepartamentoDTO {

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


    private int idDepartamento;
    private String nombre;
    private int idJefeDepartamento;
    private double presupuestoAnual;
    private ArrayList<Proyecto> proyectos;
    private ArrayList<Programador> programadores;

    public DepartamentoDTO(int idDepartamento, String nombre, int idJefeDepartamento, double presupuestoAnual) {
        this.idDepartamento = idDepartamento;
        this.nombre = nombre;
        this.idJefeDepartamento = idJefeDepartamento;
        this.presupuestoAnual = presupuestoAnual;
        this.proyectos = new ArrayList<>();
        this.programadores = new ArrayList<>();
    }

    public static DepartamentoDTO fromJSON(String json) {
        final Gson gson = new Gson();
        return gson.fromJson(json, DepartamentoDTO.class);
    }

    public String toJSON() {
        final Gson prettyGson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation() // Quitamos los campos que no están expuestos y evitamos lo anterior
                .addSerializationExclusionStrategy(strategy)
                .setPrettyPrinting()
                .create();
        // Otra manera de quitar un campo determinado para imprimir
        // prettyGson.toJsonTree(this).getAsJsonObject().remove("password");
        return prettyGson.toJson(this);
    }


}
