package service;

import dao.ProgramadorDao;
import daoImpl.ProgramadorDaoImpl;
import entidad.Commits;
import entidad.Issues;
import entidad.Programador;

import java.sql.SQLException;
import java.util.List;

public class ProgramadoresService {

    public void selectAllProgrammers() {
        System.out.println("*****MOSTRANDO TODOS LOS PROGRAMADORES*********");
        ProgramadorDao p = new ProgramadorDaoImpl();
        try {
            p.selectAllProgrammers().forEach(System.out::println);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void selectById() {
        System.out.println("*******+MOSTRANDO TODOS LOS PROGRAMADORES A TRAVES DE SU ID**********");
        ProgramadorDao p = new ProgramadorDaoImpl();
        Programador programador;
        try {

            programador = p.selectProgrammerById(10);
            System.out.println(programador);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveProgrammer() {
        System.out.println("******INSERTANDO UN NUEVO PROGRAMADOR*************" + "\n");
        ProgramadorDao p = new ProgramadorDaoImpl();
        Commits commit = new Commits("Mantenimineto", "Subiendo a staying area", "2021-16-12", 8);
        Issues issues = new Issues("Arreglando bug", "Arreglando soporte del sitema", "2009-10-29", false);
        Programador programador = new Programador("Fernando Torres", "2019-05-06", "Kotlin, PSP, Python", 2300, "456", false, 6);

        try {
            p.insertProgrammer(programador);
            programador.insertarCommit(commit);
            programador.insertarIssue(issues);

        } catch (Exception e) {
            System.err.println("Este programador no concuerda o ya está insertado ");
            e.printStackTrace();
        }
    }

    public void deleteProgrammer() {
        System.out.println("********BORRANDO UN PROGRAMADOR A TRAVES DE SU ID**********");
        ProgramadorDao p = new ProgramadorDaoImpl();
        Programador programador = new Programador(16);
        try {
            programador = p.deleteProgrammer(programador);
            System.out.println(programador);
            System.out.println("Programador borrado con exito");
        } catch (Exception e) {
            System.err.println("Este programador no concuerda o ya está borrado");
            e.printStackTrace();
        }
    }

    public void updateProgrammer() {
        System.out.println("********ACTUALIAZANDO UN PROGRAMADOR********");
        ProgramadorDao p = new ProgramadorDaoImpl();
        //Programador programador = new Programador(13, "Messi",6008);
        //  p.updateProgrammer(programador);
        // System.out.println(programador);

    }
}
