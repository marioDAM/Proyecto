package dao;

import entidad.Commits;
import entidad.Departamento;

import java.sql.SQLException;
import java.util.List;

public interface CommitsDao {
    public List<Commits> selectAllCommits() throws SQLException;

    public Commits selectCommitsById(int id) throws SQLException;

    public Commits insertCommit(Commits commit) throws SQLException;

    public Commits deleteCommit(Commits commit) throws SQLException;

    public Commits updateCommit(Commits commit) throws SQLException;
}
