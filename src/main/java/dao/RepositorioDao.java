package dao;

import entidad.Repositorio;

import java.sql.SQLException;
import java.util.List;

public interface RepositorioDao {

    List<Repositorio> selectAllRepositorios() throws SQLException;

    Repositorio selectRepositorioById(int id) throws SQLException;

    Repositorio deleteRepositorio(Repositorio repositorio) throws SQLException;

    Repositorio insertRepositorio(Repositorio repositorio) throws SQLException;

    Repositorio updateRepositorio(Repositorio repositorio) throws SQLException;
}
