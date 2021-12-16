package service;

import dao.DepartamentoDao;
import daoImpl.DepartamentoDaoImpl;
import entidad.Departamento;

import java.sql.SQLException;
import java.util.List;

public class DepartamentoService {

    public void getAllDepartments() throws SQLException {

        System.out.println("*******MOSTRANDO TODOS LOS DEPARTAMENTOS****** : " + "\n");
        DepartamentoDao d = new DepartamentoDaoImpl();
        List<Departamento> departamentos;
        try {
            departamentos = d.selectAllDepartamento();
            departamentos.forEach(System.out::println);
            System.out.println();
            System.out.println("NUMERO DE DEPARTAMENTOS QUE HAY EN LA EMPRESA");
            System.out.println(departamentos.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getAllDepartmentsByID() {
        System.out.println("*******MOSTRANDO TODOS LOS DEPARTAMENTOS A TRAVÉS DE ID****** : " + "\n");
        DepartamentoDao d = new DepartamentoDaoImpl();
        Departamento departamento;
        try {
            departamento = d.selectDepartmentsById(11);
            System.out.println(departamento);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveDepartaments() throws SQLException {
        System.out.println("******INSERTANDO UN NUEVO DEPARTAMENTO*************" + "\n");
        DepartamentoDao d = new DepartamentoDaoImpl();
        Departamento departamento = new Departamento("Economía", 1, 500);
        Departamento departamento1 = new Departamento("Programación", 2, 1400);
        try {
            d.insertDepartamento(departamento);
            d.insertDepartamento(departamento1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteDepartamento() {
        System.out.println("**********BORRANDO UN DEPARTAMENTO**********");
        DepartamentoDao d = new DepartamentoDaoImpl();
        Departamento departamento1 = new Departamento(31);
        Departamento departamento2 = new Departamento(32);
        Departamento departamento3 = new Departamento(33);
        Departamento departamento4 = new Departamento(34);
        Departamento departamento5 = new Departamento(35);
        Departamento departamento6 = new Departamento(36);
        try {
            d.deleteDepartamento(departamento1);
            System.out.println(departamento1);
            d.deleteDepartamento(departamento2);
            System.out.println(departamento2);
            d.deleteDepartamento(departamento3);
            System.out.println(departamento4);
            d.deleteDepartamento(departamento5);
            System.out.println(departamento5);
            d.deleteDepartamento(departamento6);
            System.out.println(departamento6);
            System.out.println("Departamento borrado con exito");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateDepartamento() {
        System.out.println("****ACTUALIZANDO UN DEPARTAMENTO********");
        DepartamentoDao d = new DepartamentoDaoImpl();
        Departamento departamento = new Departamento(12, "Bicicleta", 700);
        try {
            d.updateDepartamento(departamento);
            System.out.println(departamento);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
