package service;

import dao.ProgramadorDao;
import daoImpl.ProgramadorDaoImpl;
import entidad.Programador;

import java.sql.SQLException;
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

        Programador programador = new Programador("Pepe", "2021-11-10", "Javascript,Python,PHP", 1250, "123", false, 4);
        Programador programador1 = new Programador("María", "2021-09-10", "SQL, Java", 1600, "456", true, 4);

        Programador programador2 = new Programador("Luis Suárez", "2020-08-07", "Java,C#", 1360, "789", true, 5);
        Programador programador3 = new Programador("Messi", "2019-05-03", "Python,SQL", 2000, "123789", false, 5);

        try {
            p.insertProgrammer(programador);
            p.insertProgrammer(programador1);
            p.insertProgrammer(programador2);
            p.insertProgrammer(programador3);

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
