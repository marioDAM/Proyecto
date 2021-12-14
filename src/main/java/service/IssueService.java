package service;

import dao.IssueDao;
import daoImpl.IssueDaoImpl;
import entidad.Issues;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

public class IssueService {

    public void getAllIssues() {
        System.out.println("*****MOSTRANDO TODOS LAS ISSUES*****");
        IssueDao i = new IssueDaoImpl();

        try {
            i.selectAllIssues().forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getIssueById() {
        System.out.println("**********MOSTRANDO TODAS LAS ISSUES A TRAVES DE SU ID****");
        IssueDao i = new IssueDaoImpl();
        Issues issue;
        try {
            issue = i.selectIssueById(2);
            System.out.println(issue);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveIssue() {
        System.out.println("******INSERTANDO UN NUEVO ISSUE*************" + "\n");
        IssueDao i = new IssueDaoImpl();
        Issues issue = new Issues("Hola", "El saludo del personaje va mal", "11-11-1111", Boolean.TRUE);
        Issues issue2 = new Issues("Fallo cuentakilomentros", "El cuentakilomentros esta desincronizado de la aguja",
                "17-12-2012", Boolean.TRUE);
        Issues issue3 = new Issues("Hola", "El saludo del personaje vuelve a ir mal", "11-11-1111", Boolean.TRUE);
        Issues issue4 = new Issues("Viento", "el medidor de viento dobla las mediciones obtenidas",
                "11-11-1111", Boolean.FALSE);
        try {
            i.insertIssue(issue);
            i.insertIssue(issue2);
            i.insertIssue(issue3);
            i.insertIssue(issue4);
            System.out.println(issue);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateIssue() {
        System.out.println("****ACTUALIZANDO UN ISSUE********");
        IssueDao i = new IssueDaoImpl();
        Issues issue = new Issues(2, "Prueba", "Probando, probando", "1-1-2222", Boolean.FALSE);

        try {
            i.updateIssue(issue);
            System.out.println(issue);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteIssue() {
        System.out.println("**********BORRANDO UN ISSUE*********");
        IssueDao i = new IssueDaoImpl();
        Issues issue = new Issues(3);
        try {
            i.deleteIssue(issue);
            System.out.println(issue);
            System.out.println("Departamento borrado con exito");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
