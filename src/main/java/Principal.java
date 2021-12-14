

import daoSearchService.DaoBusquedaService;
import service.*;

import java.sql.SQLException;

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
        DaoBusquedaService dbs = new DaoBusquedaService();

/**
 * DEPARTAMENTOS
 */
        //ds.saveDepartaments();
//        ds.getAllDepartments();
//        ds.getAllDepartmentsByID();
        //ds.updateDepartamento();
        ds.deleteDepartamento();
//
        /**
         * PROGRAMADOR
         */

        ps.selectAllProgrammers();
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
        a.getAllAsignaciones();
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
        i.getAllIssues();
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
        dbs.busqueda2();
        System.out.println();
        dbs.busqueda3();

/**
 * JSON
 */


    }

}
