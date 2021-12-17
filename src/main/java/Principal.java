

import daoSearch.DaoBusquedas;
import service.*;

import java.sql.SQLException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) throws SQLException {

        BdSqlite bd = new BdSqlite();
        bd.checkServer();
        bd.initData();

        DepartamentoService ds = new DepartamentoService();
        ProgramadoresService ps = new ProgramadoresService();
        ProyectoService prs = new ProyectoService();
        AsignacionService a = new AsignacionService();
        CommitService c = new CommitService();
        IssueService i = new IssueService();
        ProgramadorIssueService pi = new ProgramadorIssueService();
        RepositorioService r = new RepositorioService();
        DaoBusquedas dbs = new DaoBusquedas();

        Scanner teclado = new Scanner(System.in);
/**
 * DEPARTAMENTOS
 */
       /* ds.saveDepartaments();
        ds.getAllDepartments();
        ds.getAllDepartmentsByID();
        ds.updateDepartamento();
        ds.deleteDepartamento();*/

        /**
         * PROGRAMADOR
         */

//        ps.selectAllProgrammers();
//        ps.selectById();
//        ps.saveProgrammer();
//        ps.updateProgrammer();
//        ps.deleteProgrammer();
/**
 * PROYECTOS
 */

        //prs.getAllProyectos();
        //prs.getAllProyectosByID();
        //prs.saveProyecto();
        //prs.deleteProyecto();
        //prs.updateProyecto();

/**
 * ASIGNACION
 */
        // a.getAllAsignaciones();
        //a.getAllAsignacionesById();
        //a.saveAsignacion();
        //a.deleteAsignacion();
        //a.updateAsignacion();

/**
 * COMMIT
 */
        //c.getAllCommits();
        //c.getCommitById();
        //c.saveCommit();
        //c.deleteCommit();
        //c.updateCommit();

/**
 * ISSUES
 */
        //i.getAllIssues();
        //i.getIssueById();
        // i.saveIssue();
        //i.deleteIssue();
        //i.updateIssue();

/**
 * CREACIONISSUES
 */

//        pi.selectAllProgramadorIssues();
//        pi.selectProgramadorIssueById();
        //pi.saveProgramadorIssue();
//        pi.deleteProgramadorIssue();
//        pi.updateProgramadorIssue();
/**
 * REPOSITORIO
 */
        //r.getAllRepositorios();
        //r.getRepositorioById();
        // r.saveRepositorio();
        //r.deleteRepositorio();
        //r.updateRepositorio();

        System.out.println("Inserte el ID del departamento para buscar sus trabajadores y proyectos");
        int departamento_id = teclado.nextInt();
        dbs.mostrarProgramadoresDadoDepartamento(departamento_id);
        dbs.mostrarProyectosDadoDepartamento(departamento_id);
        dbs.mostrarIssuesAbiertas();
        dbs.mostrarProyectosCommitsIssuesDadoProgramador();
        teclado.close();
/**
 * JSON
 */


    }

}
