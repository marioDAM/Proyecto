package service;

import dao.ProgramadorIssueDao;
import daoImpl.ProgramadorIssueDaoImpl;
import entidad.ProgramadorIssue;

import java.sql.SQLException;

public class ProgramadorIssueService {
    public void selectAllProgramadorIssues() {
        System.out.println("*****MOSTRANDO TODAS LAS CREATION ISSUES *********");
        ProgramadorIssueDao d = new ProgramadorIssueDaoImpl();
        try {
            d.selectAllProgramadorIssue().forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selectProgramadorIssueById() {
        System.out.println("*******+MOSTRANDO TODOS LOS Creation ISSUE A TRAVES DE SU ID**********");
        ProgramadorIssueDao d = new ProgramadorIssueDaoImpl();
        ProgramadorIssue programadorIssueIssue;
        try {
            programadorIssueIssue = d.selectProgramadorIssueById(1);
            System.out.println(programadorIssueIssue);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void saveProgramadorIssue() {
        System.out.println("******INSERTANDO UN NUEVO CREATION ISSUE***********" + "\n");
        ProgramadorIssueDao d = new ProgramadorIssueDaoImpl();
        ProgramadorIssue programadorIssue = new ProgramadorIssue(5, 6);
        ProgramadorIssue programadorIssue2 = new ProgramadorIssue(6, 7);
        ProgramadorIssue programadorIssue3 = new ProgramadorIssue(3, 4);
        ProgramadorIssue programadorIssue4 = new ProgramadorIssue(9, 12);
        try {
            d.insertProgramadorIssue(programadorIssue);
            d.insertProgramadorIssue(programadorIssue2);
            d.insertProgramadorIssue(programadorIssue3);
            d.insertProgramadorIssue(programadorIssue4);
            System.out.println(programadorIssue);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProgramadorIssue() {
        System.out.println("**********BORRANDO UN CREATION ISSUE**********");
        ProgramadorIssueDao d = new ProgramadorIssueDaoImpl();
        ProgramadorIssue programadorIssue = new ProgramadorIssue(5);
        try {
            d.deleteProgramadorIssue(programadorIssue);
            System.out.println(programadorIssue);
            System.out.println("CreacionIssue borrado con exito");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateProgramadorIssue() {
        System.out.println("****ACTUALIZANDO UN CREACION ISSUE********");
        ProgramadorIssueDao d = new ProgramadorIssueDaoImpl();
        ProgramadorIssue programadorIssue = new ProgramadorIssue(4, 5,25);
        try {
            d.updateProgramadorIssue(programadorIssue);
            System.out.println(programadorIssue);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
