package daoImpl;

import dao.CommitsDao;
import database.ConnectionPool;
import entidad.Commits;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommitDaoImpl implements CommitsDao {

    @Override
    public List<Commits> selectAllCommits() throws SQLException {
        String query = "SELECT * FROM commits";
        ConnectionPool db = ConnectionPool.getInstance();
        List<Commits> commits = new ArrayList<>();
        try {
            db.open();
            ResultSet result = db.select(query).orElseThrow(() -> new SQLException("Error al consultar la lista de commits "));

            while (result.next()) {

                commits.add(new Commits(
                        result.getInt("idCommit"),
                        result.getString("titulo"),
                        result.getString("texto"),
                        result.getString("fecha"),
                        result.getInt("asignacionPI")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();
        return commits;
    }

    @Override
    public Commits selectCommitsById(int id) throws SQLException {
        String query = "select * from commits where idCommit =? ";
        ConnectionPool db = ConnectionPool.getInstance();
        db.open();

        ResultSet result = db.select(query, id).orElseThrow(() ->
                new SQLException("Error al consultar el commit " + id));
        if ((result.next())) {
            Commits commit = new Commits(
                    result.getInt("idCommit"),
                    result.getString("titulo"),
                    result.getString("texto"),
                    result.getString("fecha"),
                    result.getInt("asignacionPI"));
            db.close();
            return commit;
        } else
            throw new SQLException("No existe el commit con id " + id);
    }

    @Override
    public Commits insertCommit(Commits commit) throws SQLException {
        String query = ("Insert into commits values (null,?,?,?,?)");
        ConnectionPool db = ConnectionPool.getInstance();
        db.open();
        ResultSet result = db.insert(query, commit.getTitulo(), commit.getTexto(), commit.getFecha(), commit.getAsignacionPI())
                .orElseThrow(() -> new SQLException("Fallo al insertar un Commit"));

        if (result.next()) {
            db.close();
            return commit;
        } else
            throw new SQLException("Error al insertar el commit");
    }

    @Override
    public Commits deleteCommit(Commits commit) throws SQLException {
        String query = "DELETE FROM commits WHERE idCommit  = ?";
        ConnectionPool db = ConnectionPool.getInstance();
        db.open();
        int res = db.delete(query, commit.getIdCommit());
        db.close();
        if (res > 0)
            return commit;
        throw new SQLException("Fallo al borrar el Commit " + commit.getIdCommit());
    }

    @Override
    public Commits updateCommit(Commits commit) throws SQLException {
        String query = "UPDATE commit SET titulo=?, texto=?, fecha=?, idProgramadorIssue = ? WHERE idCommit=?";
        ConnectionPool db = ConnectionPool.getInstance();
        db.open();
        int res = db.update(query, commit.getTitulo(), commit.getTexto(), commit.getFecha(), commit.getAsignacionPI() ,commit.getIdCommit());
        db.close();
        if (res > 0)
            return commit;
        else throw new SQLException("Fallo al actualizar el commit de id " + commit.getIdCommit());
    }
}
