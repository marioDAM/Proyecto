package dao;

import entidad.ProgramadorIssue;

import java.sql.SQLException;
import java.util.List;

public interface ProgramadorIssueDao {
    List<ProgramadorIssue> selectAllProgramadorIssue() throws SQLException;

    ProgramadorIssue selectProgramadorIssueById(int id) throws SQLException;

    ProgramadorIssue insertProgramadorIssue(ProgramadorIssue programadorIssue) throws SQLException;

    ProgramadorIssue deleteProgramadorIssue(ProgramadorIssue programadorIssue) throws SQLException;

    ProgramadorIssue updateProgramadorIssue(ProgramadorIssue programadorIssue) throws SQLException;
}
