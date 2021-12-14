package daoImpl;

import dao.IssueDao;
import database.ConnectionPool;
import entidad.Issues;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IssueDaoImpl implements IssueDao {
    @Override
    public List<Issues> selectAllIssues() throws SQLException {

        String query = "SELECT * FROM issues";

        ConnectionPool db = ConnectionPool.getInstance();
        List<Issues> issue = new ArrayList<>();
        try {
            db.open();
            ResultSet result = db.select(query).orElseThrow(() ->
                    new SQLException("Error al consultar el registro de Issues"));

            while (result.next()) {
                issue.add(new Issues(
                        result.getInt("idIssue"),
                        result.getString("titulo"),
                        result.getString("texto"),
                        result.getString("fecha"),
                        result.getBoolean("estado")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();
        return issue;
    }

    @Override
    public Issues selectIssueById(int id) throws SQLException {

        String query = "SELECT * FROM issues WHERE idIssue=? ";

        ConnectionPool db = ConnectionPool.getInstance();

        db.open();
        ResultSet result = db.select(query).orElseThrow(() ->
                new SQLException("Error al consultar el Issue con ID" + id));

        if (result.next()) {
            Issues issue = new Issues(
                    result.getInt("idIssue"),
                    result.getString("titulo"),
                    result.getString("texto"),
                    result.getString("fecha"),
                    result.getBoolean("estado"));
            db.close();
            return issue;


        } else throw new SQLException("Error no existe Issue con ID: " + id);


    }

    @Override
    public Issues deleteIssue(Issues issue) throws SQLException {
        String query = "DELETE FROM issues WHERE idIssue=?";
        ConnectionPool db = ConnectionPool.getInstance();
        db.open();
        int res = db.delete(query, issue.getIdIssue());
        db.close();
        if (res > 0)
            return issue;
        throw new SQLException("Error al borrar el Issue");
    }

    @Override
    public Issues insertIssue(Issues issue) throws SQLException {
        String query = "INSERT INTO issues values(null,?,?,?,?)";
        ConnectionPool db = ConnectionPool.getInstance();
        db.open();
        ResultSet result = db.insert(query, issue.getTitulo(), issue.getTexto(), issue.getFecha(), issue.isEstado()).orElseThrow(()
                -> new SQLException("Error al insertar el Issue"));

        if (result.next()) {
            issue.setIdIssue(result.getInt(1));
            db.close();
            return issue;
        } else throw new SQLException("Error al insertar el nuevo Issue");

    }

    @Override
    public Issues updateIssue(Issues issue) throws SQLException {
        String query = "UPDATE issue SET titulo=?, texto=?, fecha=?, estado = ? WHERE idIssue=?";
        ConnectionPool db = ConnectionPool.getInstance();
        db.open();
        int result = db.update(query, issue.getTitulo(), issue.getTexto(), issue.getFecha(), issue.isEstado() ,issue.getIdIssue());
        if (result > 0)
            return issue;
        else
            throw new SQLException("Error  al actualizar el issue id: " + issue.getIdIssue());


    }


}



