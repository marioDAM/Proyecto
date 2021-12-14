package service;

import dao.ProyectoDao;
import daoImpl.ProyectoDaoImpl;
import entidad.Proyecto;
import java.sql.SQLException;
import java.util.List;

public class ProyectoService {

    public void getAllProyectos(){
        System.out.println("*******MOSTRANDO TODOS LOS PROYECTOS****** : " + "\n");
        ProyectoDao p= new ProyectoDaoImpl();
        List<Proyecto> proyectos;
        try{
            proyectos=p.selectAllProjects();
            proyectos.forEach(System.out::println);
            System.out.println("Número de Repositorios existentes: "+p.selectAllProjects().size());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getAllProyectosByID(){
        System.out.println("*******MOSTRANDO TODOS LOS PROYECTOS A TRAVÉS DE ID****** : " + "\n");
        ProyectoDao p= new ProyectoDaoImpl();
        Proyecto proyecto;
        try {
            proyecto=p.selectById(1);
            System.out.println(proyecto);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveProyecto(){
        System.out.println("******INSERTANDO UN NUEVO PROYECTO*************" + "\n");
        ProyectoDao p= new ProyectoDaoImpl();


        Proyecto proyecto= new Proyecto( "Coche",2,2222,"12-2-1999",
                "2020","Java, Python", 12);
        Proyecto proyecto2= new Proyecto( "Avion",3,8888,"12-11-1990",
                "2021","Git, Node", 13);
        Proyecto proyecto3= new Proyecto( "Avion",4,12134,"1-11-2010",
                "2022","JavaScript, MYSQL", 13);
        try{
            p.insertProyect(proyecto);
            p.insertProyect(proyecto2);
            p.insertProyect(proyecto3);
            System.out.println(proyecto);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProyecto(){
        System.out.println("**********BORRANDO UN PROYECTO**********");
        ProyectoDao p= new ProyectoDaoImpl();
        Proyecto proyecto= new Proyecto(4);
        try{
            p.deleteProyecto(proyecto);
            System.out.println(proyecto);
            System.out.println("Departamento borrado con exito");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateProyecto(){
        System.out.println("**********ACTUALIZANDO UN PROYECTO**********");
        ProyectoDao p= new ProyectoDaoImpl();
        Proyecto proyecto= new Proyecto(6,"bicicleta",4,121340,"1-11-2010",
                "2022","Kotlin", 13);
        try {
            p.updateProyect(proyecto);
            System.out.println(proyecto);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
