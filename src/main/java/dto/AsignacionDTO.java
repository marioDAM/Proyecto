package dto;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entidad.Programador;
import entidad.Proyecto;
import lombok.Data;

import java.util.Date;

@Data

public class AsignacionDTO {

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

    private int idAsignacion;
    private Date fechaAsignacion;
    private Programador programador;
    private Proyecto proyecto;

    public AsignacionDTO(int idAsignacion, Date fechaAsignacion, Programador programador, Proyecto proyecto) {
        this.idAsignacion = idAsignacion;
        this.fechaAsignacion = fechaAsignacion;
        this.programador = programador;
        this.proyecto = proyecto;
    }

    public static AsignacionDTO fromJSON(String json) {
        final Gson gson = new Gson();
        return gson.fromJson(json, AsignacionDTO.class);
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

