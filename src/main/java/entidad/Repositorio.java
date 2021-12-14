package entidad;

import lombok.Data;

import java.util.Date;


@Data
public class Repositorio {

    private int idRepositorio;
    private String nombre;
    private String fechaCreacion;

    public Repositorio(int idRepositorio, String nombre, String fechaCreacion) {
        this.idRepositorio = idRepositorio;
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
    }

    public Repositorio(String nombre, String fechaCreacion) {
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
    }


    public Repositorio(int idRepositorio) {
        this.idRepositorio = idRepositorio;

    }
}