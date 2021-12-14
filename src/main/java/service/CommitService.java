package service;

import dao.CommitsDao;
import daoImpl.CommitDaoImpl;
import entidad.Commits;


import java.sql.SQLException;
import java.util.List;

public class CommitService {

    public void getAllCommits() throws SQLException {
        System.out.println("*******MOSTRANDO TODOS LOS COMMITS****** : " + "\n");
        CommitsDao c= new CommitDaoImpl();
        List<Commits>commits;
        try {
            commits=c.selectAllCommits();
            commits.forEach(System.out::println);
            System.out.println("Número de Repositorios existentes: "+c.selectAllCommits().size());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getCommitById(){
        System.out.println("*******MOSTRANDO EL COMMIT DE ID SELECCIONADA****** : " + "\n");
        CommitsDao c= new CommitDaoImpl();
        Commits commit;
        try{
            commit=c.selectCommitsById(1);
            System.out.println(commit);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveCommit(){
        System.out.println("******INSERTANDO UN NUEVO COMMIT*************" + "\n");
        CommitsDao c= new CommitDaoImpl();
        Commits commit= new Commits("Saludos","Arreglo del dialogo de saludo","1-5-2012",7);
        Commits commit2= new Commits("Agua","AAñadiendo correctamente las texturas del agua","1-2-2012",6);
        Commits commit3= new Commits("Sincronizacion","Sincronizacion de la aguja del cuentakilometros","1-6-2017",9);
        Commits commit4= new Commits("Saludos2","Arreglo del dialogo de saludo... otra vez","4-5-2012",7);
        try{
            c.insertCommit(commit);
            c.insertCommit(commit2);
            c.insertCommit(commit3);
            c.insertCommit(commit4);
            System.out.println(commit);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCommit(){
        System.out.println("********BORRANDO UN COMMIT A TRAVES DE LA ID**********");
        CommitsDao c=new CommitDaoImpl();
        Commits commit= new Commits(13);
        try {
            c.deleteCommit(commit);
            System.out.println(commit);
            System.out.println("Commit borrado con exito");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    public void updateCommit(){
        System.out.println("****ACTUALIZANDO UN COMMIT********");
        CommitsDao c= new CommitDaoImpl();
        Commits commit= new Commits(15,"Actualización","Añadiendo correctamente las texturas del agua","1-2-2012",6);
        try{
            c.updateCommit(commit);
            System.out.println(commit);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
