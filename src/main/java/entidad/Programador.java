package entidad;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Programador {

    private int idProgramadores;
    private String nombre;
    private String fechaAlta;
    private String tecnologias;
    private double salario;
    private String password;
    private boolean esJefe;
    private int departamento;
    private ArrayList<Commits> commits;
    private ArrayList<Issues> issues;

    public Programador(int idProgramadores, String nombre, String fechaAlta, String tecnologias, double salario, String password, boolean esJefe, int departamento) {
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

    public Programador(String nombre, String fechaAlta, String tecnologias, double salario, String password, boolean esJefe, int departamento) {
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

    public Programador(int idProgramadores) {
        this.idProgramadores = idProgramadores;
    }


    public void insertarCommit(Commits c) {
        this.commits.add(c);
        System.out.println("Commits del programador :");
        commits.forEach(System.out::println);
    }

    public void insertarIssue(Issues i) {
        this.issues.add(i);
        System.out.println("Issues del programador :");
        issues.forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "Programador{" +
                "idProgramadores=" + idProgramadores +
                ", nombre='" + nombre + '\'' +
                ", fechaAlta='" + fechaAlta + '\'' +
                ", tecnologias='" + tecnologias + '\'' +
                ", salario=" + salario +
                ", password='" + password + '\'' +
                ", esJefe=" + esJefe +
                ", departamento=" + departamento +
                '}';
    }
}
