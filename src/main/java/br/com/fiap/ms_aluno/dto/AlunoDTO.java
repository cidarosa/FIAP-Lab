package br.com.fiap.ms_aluno.dto;

import br.com.fiap.ms_aluno.model.Aluno;
import br.com.fiap.ms_aluno.model.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AlunoDTO {

    private Long id;
    @NotNull(message = "Nome requerido")
    @NotBlank(message = "Nome não pode ser vazio")
    private String nome;
    private String email;
    private String password;
    private String rm;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String turma;

    public AlunoDTO(Aluno entity) {
        id = entity.getId();
        nome = entity.getNome();
        email = entity.getEmail();
        password = entity.getPassword();
        rm = entity.getRm();
        status = entity.getStatus();
        turma = entity.getTurma();
    }
}
