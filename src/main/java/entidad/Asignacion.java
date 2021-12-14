package entidad;

import lombok.Data;

import java.util.Date;

@Data
public class Asignacion {

    private int idAsignacion;
    private String fechaAsignacion;
    private int idProyecto;
    private int idProgramador;

    public Asignacion(int idAsignacion, String fechaAsignacion, int idProyecto, int idProgramador) {
        this.idAsignacion = idAsignacion;
        this.fechaAsignacion = fechaAsignacion;
        this.idProyecto = idProyecto;
        this.idProgramador = idProgramador;
    }

    public Asignacion(String fechaAsignacion, int idProyecto, int idProgramador) {
        this.fechaAsignacion = fechaAsignacion;
        this.idProyecto = idProyecto;
        this.idProgramador = idProgramador;
    }

    public Asignacion(int idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    public Asignacion(String fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    @Override
    public String toString() {
        return "Asignacion{" +
                "idAsignacion=" + idAsignacion +
                ", fechaAsignacion=" + fechaAsignacion +
                ", idProyecto=" + idProyecto +
                ", idProgramador=" + idProgramador +
                '}';
    }
}
