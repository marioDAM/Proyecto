package dao;


import entidad.Issues;

import java.sql.SQLException;
import java.util.List;

public interface IssueDao {
    List<Issues> selectAllIssues() throws SQLException;

    Issues selectIssueById(int id) throws SQLException;

    Issues deleteIssue(Issues issue) throws SQLException;

    Issues insertIssue(Issues issue) throws SQLException;

    Issues updateIssue(Issues issue) throws SQLException;
}
