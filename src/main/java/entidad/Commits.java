package entidad;

import lombok.Data;

import java.util.Date;

@Data
public class Commits {

    private int idCommit;
    private String titulo;
    private String texto;
    private String fecha;
    private int asignacionPI;

    public Commits(int idCommit) {
        this.idCommit = idCommit;
    }

    public Commits(int idCommit, String titulo, String texto, String fecha, int asignacionPI) {
        this.idCommit = idCommit;
        this.titulo = titulo;
        this.texto = texto;
        this.fecha = fecha;
        this.asignacionPI = asignacionPI;
    }

    public Commits(String titulo, String texto, String fecha, int asignacionPI) {
        this.titulo = titulo;
        this.texto = texto;
        this.fecha = fecha;
        this.asignacionPI = asignacionPI;
    }

    @Override
    public String toString() {
        return "Commits{" +
                "idCommit=" + idCommit +
                ", titulo='" + titulo + '\'' +
                ", texto='" + texto + '\'' +
                ", fecha='" + fecha + '\'' +
                ", asignacionPI=" + asignacionPI +
                '}';
    }
}