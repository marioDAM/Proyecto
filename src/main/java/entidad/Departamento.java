package entidad;


import dao.CrudRespository;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Departamento implements CrudRespository<Departamento> {

    private int idDepartamento;
    private String nombre;
    private int idJefeDepartamento;
    private double presupuestoAnual;
    private ArrayList<Proyecto> proyectos;
    private ArrayList<Programador> programadores;

    public Departamento(int idDepartamento, String nombre, int idJefeDepartamento, double presupuestoAnual) {
        this.idDepartamento = idDepartamento;
        this.nombre = nombre;
        this.idJefeDepartamento = idJefeDepartamento;
        this.presupuestoAnual = presupuestoAnual;
        this.proyectos = new ArrayList<>();
        this.programadores = new ArrayList<>();
    }

    public Departamento(String nombre, int idJefeDepartamento, double presupuestoAnual) {
        this.nombre = nombre;
        this.idJefeDepartamento = idJefeDepartamento;
        this.presupuestoAnual = presupuestoAnual;
        this.proyectos = new ArrayList<>();
        this.programadores = new ArrayList<>();
    }

    public Departamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public Departamento(int idDepartamento, String nombre, double presupuestoAnual) {
        this.idDepartamento = idDepartamento;
        this.nombre = nombre;
        this.presupuestoAnual = presupuestoAnual;
    }

    public void insertarProgramador(Programador p) {
        this.programadores.add(p);
    }

    public void insertarProyecto(Proyecto p) {
        this.proyectos.add(p);
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "idDepartamento=" + idDepartamento +
                ", nombre='" + nombre + '\'' +
                ", idJefeDepartamento=" + idJefeDepartamento +
                ", presupuestoAnual=" + presupuestoAnual +
                '}';
    }


    @Override
    public List<Departamento> findAll() throws SQLException {
        return null;
    }

    @Override
    public Departamento getById(int id) throws SQLException {
        return null;
    }

    @Override
    public Departamento save(Departamento departamento) throws SQLException {
        return null;
    }

    @Override
    public Departamento update(Departamento departamento) throws SQLException {
        return null;
    }

    @Override
    public Departamento delete(Departamento departamento) throws SQLException {
        return null;
    }
}
