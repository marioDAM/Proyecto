package daoImpl;

import dao.ProgramadorIssueDao;
import database.ConnectionPool;
import entidad.ProgramadorIssue;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProgramadorIssueDaoImpl implements ProgramadorIssueDao {


    @Override
    public List<ProgramadorIssue> selectAllProgramadorIssue() throws SQLException {
        String query = "select * from programadorIssue";
        ConnectionPool db = ConnectionPool.getInstance();
        List<ProgramadorIssue> creacionIssues = new ArrayList<>();
        try {
            db.open();
            ResultSet result = db.select(query).orElseThrow(() -> new SQLException("Error al consultar registro de programadorIssue"));

            while (result.next()) {
                creacionIssues.add(new ProgramadorIssue(
                        result.getInt("idAsignacion"),
                        result.getInt("idProgramador"),
                        result.getInt("idIssue")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return creacionIssues;
    }

    @Override
    public ProgramadorIssue selectProgramadorIssueById(int id) throws SQLException {
        String query = "select * from programadorIssue where idProgramadorIssue =? ";
        ConnectionPool db = ConnectionPool.getInstance();

        db.open();
        ResultSet result = db.select(query, id).orElseThrow(() ->
                new SQLException("Error al consultar el ProgramadorIssue con ID " + id));
        if (result.next()) {
            ProgramadorIssue creacionIssue = new ProgramadorIssue(
                    result.getInt("idProgramadorIssue"),
                    result.getInt("idProgramador"),
                    result.getInt("idIssue"));

            db.close();
            return creacionIssue;
        } else
            throw new SQLException("Error no existe ProgramadorIssue con ID: " + id);
    }

    @Override
    public ProgramadorIssue insertProgramadorIssue(ProgramadorIssue programadorIssue) throws SQLException {
        String query = ("Insert into programadorIssue values (null,?,?)");
        ConnectionPool db = ConnectionPool.getInstance();
        db.open();
        ResultSet result = db.insert(query, programadorIssue.getIdProgramador(), programadorIssue.getIdIssue())
                .orElseThrow(() -> new SQLException("Error UserRepository al insertar el CreacionIssue"));
        if (result.next()) {
            db.close();
            return programadorIssue;
        } else throw new SQLException("Error  al ProgramadorIssue en BD");
    }

    @Override
    public ProgramadorIssue deleteProgramadorIssue(ProgramadorIssue programadorIssue) throws SQLException {
        String query = "DELETE FROM programadorIssue WHERE idProgramadorIssue  = ?";
        ConnectionPool db = ConnectionPool.getInstance();
        db.open();
        int res = db.delete(query, programadorIssue.getIdProgramadorIssue());
        db.close();
        if (res > 0)
            return programadorIssue;
        throw new SQLException("Error UserRepository al actualizar ProgramadorIssue con id: " + programadorIssue.getIdProgramadorIssue());
    }

    @Override
    public ProgramadorIssue updateProgramadorIssue(ProgramadorIssue programadorIssue) throws SQLException {
        String query = "UPDATE programadorIssue SET idProgramador= ? , idIssue =? WHERE idProgramadorIssue = ?";
        ConnectionPool db = ConnectionPool.getInstance();
        db.open();
        int res = db.update(query, programadorIssue.getIdProgramador(), programadorIssue.getIdIssue(), programadorIssue.getIdProgramadorIssue());
        db.close();
        if (res > 0)
            return programadorIssue;
        else
            throw new SQLException("Error al actualizar ProgramadorIssue con id: " + programadorIssue.getIdProgramadorIssue());
    }
}
