package entidad;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;


@Data
public class Issues {

    private int idIssue;
    private String titulo;
    private String texto;
    private String fecha;
    private boolean estado;
    private ArrayList<Programador> programadores;

    public Issues(int idIssue, String titulo, String texto, String fecha, boolean estado) {
        this.idIssue = idIssue;
        this.titulo = titulo;
        this.texto = texto;
        this.fecha = fecha;
        this.estado = estado;
        this.programadores = new ArrayList<>();
    }

    public Issues(String titulo, String texto, String fecha, boolean estado) {
        this.titulo = titulo;
        this.texto = texto;
        this.fecha = fecha;
        this.estado = estado;
    }

    public Issues(int idIssue) {
        this.idIssue = idIssue;
    }



    public void insertarProgramador(Programador p) {
        this.programadores.add(p);


    }
}