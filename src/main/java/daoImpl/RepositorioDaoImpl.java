package daoImpl;

import dao.RepositorioDao;
import database.ConnectionPool;
import entidad.Repositorio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepositorioDaoImpl implements RepositorioDao {
    @Override
    public List<Repositorio> selectAllRepositorios() throws SQLException {
        String query = "SELECT * FROM repositorio";
        ConnectionPool db = ConnectionPool.getInstance();
        List<Repositorio> repositorios = new ArrayList<>();
        try {
            db.open();
            ResultSet result = db.select(query).orElseThrow(() ->
                    new SQLException("Error al consultar el registro de Repositorios"));

            while (result.next()) {
                db.open();

                repositorios.add(new Repositorio(
                        result.getInt("idRepositorio"),
                        result.getString("nombre"),
                        result.getString("fechaCreacion")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return repositorios;
    }

    @Override
    public Repositorio selectRepositorioById(int id) throws SQLException {
        String query = "SELECT * FROM repositorio WHERE idRepositorio=? ";

        ConnectionPool db = ConnectionPool.getInstance();

        db.open();

        ResultSet result = db.select(query, id).orElseThrow(() ->
                new SQLException("Error al consultar departamento con ID " + id));

        if (result.next()) {
            Repositorio repositorio = new Repositorio(
                    result.getInt("idRepositorio"),
                    result.getString("nombre"),
                    result.getString("fechaCreacion"));
            db.close();
            return repositorio;

        } else
            throw new SQLException("Error no existe un Repositorio con ID: " + id);
    }

    @Override
    public Repositorio deleteRepositorio(Repositorio repositorio) throws SQLException {
        String query = "DELETE FROM repositorio WHERE idRepositorio= ?";
        ConnectionPool db = ConnectionPool.getInstance();
        db.open();
        int res = db.delete(query, repositorio.getIdRepositorio());
        db.close();
        if (res > 0)

            return repositorio;
        throw new SQLException("Error RepositorioRepository al borrar el repositorio con id: " + repositorio.getIdRepositorio());
    }

    @Override
    public Repositorio insertRepositorio(Repositorio repositorio) throws SQLException {
        String query = "insert into repositorio values(null,?,?)";
        ConnectionPool db = ConnectionPool.getInstance();
        db.open();
        ResultSet result = db.insert(query, repositorio.getNombre(), repositorio.getFechaCreacion()).orElseThrow(() ->
                new SQLException("Error al insertar el Repositorio"));

        if (result.next()) {
            db.close();
            return repositorio;
        } else throw new SQLException("Error al insertar un repositorio");

    }

    @Override
    public Repositorio updateRepositorio(Repositorio repositorio) throws SQLException {
        String query = "UPDATE repositorio SET nombre=?, fechaCreacion=? WHERE idRepositorio = ?";
        ConnectionPool db = ConnectionPool.getInstance();
        db.open();
        int res = db.update(query, repositorio.getNombre(), repositorio.getFechaCreacion(), repositorio.getIdRepositorio());
        db.close();
        if (res > 0)
            return repositorio;
        else throw new SQLException("Error al actualizar el repositorio con id: " + repositorio.getIdRepositorio());

    }
}
