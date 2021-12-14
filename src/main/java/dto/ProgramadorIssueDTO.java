package dto;

import entidad.Issues;
import entidad.Programador;

public class ProgramadorIssueDTO {
    private int idProgramadorIssue;
    private Programador programador;
    private Issues issue;

    public ProgramadorIssueDTO(int idProgramadorIssue, Programador programador, Issues issue) {
        this.idProgramadorIssue = idProgramadorIssue;
        this.programador = programador;
        this.issue = issue;
    }


}
