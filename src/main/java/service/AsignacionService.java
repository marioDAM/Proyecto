package service;

import dao.AsignacionDao;
import daoImpl.AsignacionDaoImpl;
import entidad.Asignacion;
import entidad.Departamento;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class AsignacionService {

    public void getAllAsignaciones() {
        System.out.println("*******MOSTRANDO TODOS LOS DEPARTAMENTOS****** : " + "\n");
        AsignacionDao a = new AsignacionDaoImpl();
        List<Asignacion> asignaciones;
        try {
            asignaciones = a.selectAllAsignaciones();
            asignaciones.forEach(System.out::println);
            System.out.println("Número de Asignaciones existentes: " + a.selectAllAsignaciones().size());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void getAllAsignacionesById() {
        System.out.println("*******MOSTRANDO TODOS LAS ASIGNACIONES A TRAVÉS DE ID****** : " + "\n");
        AsignacionDao a = new AsignacionDaoImpl();
        Asignacion asignacion;
        try {
            asignacion = a.selectAsignacionPorId(2);
            System.out.println(asignacion);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void saveAsignacion() {
        System.out.println("******INSERTANDO UNA NUEVA ASIGNACION***********" + "\n");
        AsignacionDao a = new AsignacionDaoImpl();
        Asignacion asignacion = new Asignacion("2-12-2020", 4, 13);
        Asignacion asignacion2 = new Asignacion("21-12-2010", 5, 12);
        Asignacion asignacion3 = new Asignacion("3-1-2020", 6, 11);
        Asignacion asignacion4 = new Asignacion("7-7-2017", 7, 10);
        try {
            a.insertAsignacion(asignacion);
            a.insertAsignacion(asignacion2);
            a.insertAsignacion(asignacion3);
            a.insertAsignacion(asignacion4);
            System.out.println(asignacion);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAsignacion() {
        System.out.println("**********BORRANDO UNA ASIGNACION**********");
        AsignacionDao a = new AsignacionDaoImpl();
        Asignacion asignacion = new Asignacion(4);
        try {
            a.deleteAsignacion(asignacion);
            System.out.println(asignacion);
            System.out.println("Asignacion borrado con exito");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAsignacion() {
        System.out.println("**********ACTUALIZANDO UNA ASIGNACION**********");
        AsignacionDao a = new AsignacionDaoImpl();
        Asignacion asignacion = new Asignacion(1, "1-1-1111", 1, 1);
        try {
            a.updateAsignacion(asignacion);
            System.out.println(asignacion);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


