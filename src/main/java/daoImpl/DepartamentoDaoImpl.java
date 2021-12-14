package daoImpl;

import dao.DepartamentoDao;
import database.ConnectionPool;
import entidad.Departamento;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

public class DepartamentoDaoImpl implements DepartamentoDao {
    @Override
    public List<Departamento> selectAllDepartamento() throws SQLException {
        String query = "select * from departamento";
        ConnectionPool db = ConnectionPool.getInstance();
        List<Departamento> departamentos = new ArrayList<>();
        try {
            db.open();
            ResultSet result = db.select(query).orElseThrow(() -> new SQLException("Error al consultar registro de departamentos "));
            while (result.next()) {
                db.open();
                departamentos.add(new Departamento(
                        result.getInt("idDepartamento"),
                        result.getString("nombre"),
                        result.getInt("idJefeDepartamento"),
                        result.getDouble("presupuestoAnual")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();
        return departamentos;
    }

    @Override
    public Departamento selectDepartmentsById(int id) throws SQLException {
        String query = "select * from departamento where idDepartamento =? ";
        ConnectionPool db = ConnectionPool.getInstance();
        db.open();
        ResultSet result = db.select(query, id).orElseThrow(() ->
                new SQLException("Error al consultar usuario con ID " + id));
        if (result.next()) {
            Departamento departamento = new Departamento(
                    result.getInt("idDepartamento"),
                    result.getString("nombre"),
                    result.getInt("idJefeDepartamento"),
                    result.getDouble("presupuestoAnual"));
            db.close();
            return departamento;
        } else
            throw new SQLException("Error no existe Departamento con ID: " + id);
    }

    @Override
    public Departamento insertDepartamento(Departamento departamento) throws SQLException {
        String query = ("Insert into departamento values (null,?,?,?)");
        ConnectionPool db = ConnectionPool.getInstance();
        db.open();
        ResultSet result = db.insert(query, departamento.getNombre(), departamento.getIdJefeDepartamento(), departamento.getPresupuestoAnual()
        ).orElseThrow(() -> new SQLException("Error DepartamentoRepository al insertar Departamento"));
        if (result.next()) {
            db.close();
            return departamento;
        } else
            throw new SQLException("Error DepartamentoDao al insertar departamento en BD");
    }

    @Override
    public Departamento deleteDepartamento(Departamento departamento) throws SQLException {
        String query = "DELETE FROM departamento WHERE idDepartamento  = ?";
        ConnectionPool db = ConnectionPool.getInstance();
        db.open();
        int res = db.delete(query, departamento.getIdDepartamento());
        db.close();
        if (res > 0)
            return departamento;
        throw new SQLException("Error DepartamentoRepository al actualizar departamento con id: " + departamento.getIdDepartamento());

    }

    @Override
    public Departamento updateDepartamento(Departamento departamento) throws SQLException {
        String query = "UPDATE departamento SET nombre = ?, presupuestoAnual = ?, idJefeDepartamento = ? WHERE idDepartamento = ?";
        ConnectionPool db = ConnectionPool.getInstance();
        db.open();
        int res = db.update(query, departamento.getNombre(), departamento.getPresupuestoAnual(), departamento.getIdJefeDepartamento(), departamento.getIdDepartamento());
        db.close();
        if (res > 0)
            return departamento;
        else
            throw new SQLException("Error DepartamentoRepository al actualizar departamento con id: " + departamento.getIdDepartamento());
    }

}
