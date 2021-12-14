package entidad;

import dao.CrudRespository;
import lombok.Builder;
import lombok.Data;

import java.sql.SQLException;
import java.util.List;

@Data

public class Proyecto implements CrudRespository<Proyecto> {

    private int idProyecto;
    private String nombre;
    private int idJefeProyecto;
    private double presupuesto;
    private String fechaInicio;
    private String fechaFin;
    private String tecnologias;
    private int repositorio;


    public Proyecto(int idProyecto, String nombre, int idJefeProyecto, double presupuesto, String fechaInicio, String fechaFin, String tecnologias, int repositorio) {
        this.idProyecto = idProyecto;
        this.nombre = nombre;
        this.idJefeProyecto = idJefeProyecto;
        this.presupuesto = presupuesto;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.tecnologias = tecnologias;
        this.repositorio = repositorio;
    }

    public Proyecto(int idProyecto) {
        this.idProyecto=idProyecto;
    }

    public Proyecto(String nombre, int idJefeProyecto, double presupuesto, String fechaInicio, String fechaFin, String tecnologias, int repositorio) {
        this.nombre = nombre;
        this.idJefeProyecto = idJefeProyecto;
        this.presupuesto = presupuesto;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.tecnologias = tecnologias;
        this.repositorio = repositorio;
    }

    @Override
    public String toString() {
        return "Proyecto{" +
                "idProyecto=" + idProyecto +
                ", nombre='" + nombre + '\'' +
                ", idJefeProyecto=" + idJefeProyecto +
                ", presupuesto=" + presupuesto +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", tecnologias=" + tecnologias +
                ", repositorio=" + repositorio +
                '}';
    }






















    @Override
    public List<Proyecto> findAll() throws SQLException {
        return null;
    }

    @Override
    public Proyecto getById(int id) throws SQLException {
        return null;
    }

    @Override
    public Proyecto save(Proyecto proyecto) throws SQLException {
        return null;
    }

    @Override
    public Proyecto update(Proyecto proyecto) throws SQLException {
        return null;
    }

    @Override
    public Proyecto delete(Proyecto proyecto) throws SQLException {
        return null;
    }
}
