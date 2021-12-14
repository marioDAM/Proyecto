package daoSearchService;

import daoSearch.DaoBusquedas;
import entidad.Issues;
import entidad.Programador;

import java.sql.SQLException;
import java.util.List;

public class DaoBusquedaService {
    public void busqueda2() throws SQLException {
        DaoBusquedas db = new DaoBusquedas();
        try {
            System.out.println("Listado de issues abeirtas que no se hayan cosolidado en commits");
            List<Issues> isues = db.busqueda2();
            isues.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void busqueda3() {
        DaoBusquedas db = new DaoBusquedas();
        try {
            System.out.println("Programadores de un proyecto ordenados por número de commits");
            List<Programador> programadores = db.busqueda3(5);
            programadores.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
