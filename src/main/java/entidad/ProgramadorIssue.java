package entidad;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data

public class ProgramadorIssue {

    private int idProgramadorIssue;
    private int idProgramador;
    private int idIssue;

    public ProgramadorIssue(int idProgramador, int idIssue) {
        this.idProgramador = idProgramador;
        this.idIssue = idIssue;
    }

    public ProgramadorIssue(int idProgramadorIssue, int idProgramador, int idIssue) {
        this.idProgramadorIssue = idProgramadorIssue;
        this.idProgramador = idProgramador;
        this.idIssue = idIssue;
    }

    public ProgramadorIssue(int idProgramadorIssue) {
        this.idProgramadorIssue = idProgramadorIssue;
    }
}
