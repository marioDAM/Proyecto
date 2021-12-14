package dao;


import entidad.Programador;

import java.sql.SQLException;
import java.util.List;

public interface ProgramadorDao {

    List<Programador> selectAllProgrammers() throws SQLException;

    Programador selectProgrammerById(int id) throws SQLException;

    Programador insertProgrammer(Programador programador) throws SQLException;

    Programador deleteProgrammer(Programador programador) throws SQLException;

    Programador updateProgrammer(Programador programador) throws SQLException;
}
