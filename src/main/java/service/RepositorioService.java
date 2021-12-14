package service;

import dao.RepositorioDao;
import daoImpl.RepositorioDaoImpl;
import entidad.Repositorio;

import java.sql.SQLException;

public class RepositorioService {

    public void getAllRepositorios() {
        System.out.println("*******MOSTRANDO TODOS LOS REPOSITORIOS***********");
        RepositorioDao r = new RepositorioDaoImpl();
        try {
            r.selectAllRepositorios().forEach(System.out::println);
            System.out.println("Número de Repositorios existentes: " + r.selectAllRepositorios().size());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getRepositorioById() {
        System.out.println("*******MOSTRANDO EL REPOSITORIO A TRAVES DE SU ID**********");
        RepositorioDao r = new RepositorioDaoImpl();
        Repositorio repositorio;
        try {
            repositorio = r.selectRepositorioById(1);
            System.out.println(repositorio);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveRepositorio() throws SQLException {
        System.out.println("******INSERTANDO UN NUEVO REPOSITORIO*************" + "\n");
        RepositorioDao r = new RepositorioDaoImpl();
        Repositorio repositorio = new Repositorio("Cuentakilomentros coche","17-5-2009");
        Repositorio repositorio2 = new Repositorio("Juego Sandbox","4-5-2020");
        Repositorio repositorio3 = new Repositorio("Medidor Velocidad viento","12-2-2014");
        Repositorio repositorio4 = new Repositorio("Brazo robótico","13-11-2015");
        try {
            r.insertRepositorio(repositorio);
            r.insertRepositorio(repositorio2);
            r.insertRepositorio(repositorio3);
            r.insertRepositorio(repositorio4);
            System.out.println(repositorio);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteRepositorio() {
        System.out.println("*******BORRANDO EL REPOSITORIO*******");
        RepositorioDao r = new RepositorioDaoImpl();
        Repositorio repositorio = new Repositorio(4);
        try {
            r.deleteRepositorio(repositorio);
            System.out.println(repositorio);
            System.out.println("Repositorio borrado con exito");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateRepositorio() {
        System.out.println("****ACTUALIZANDO UN REPOSITORIO********");
        RepositorioDao r = new RepositorioDaoImpl();
        Repositorio repositorio = new Repositorio(3, "Cohete", "16-7-1969");
        try {
            r.updateRepositorio(repositorio);
            System.out.println(repositorio);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
