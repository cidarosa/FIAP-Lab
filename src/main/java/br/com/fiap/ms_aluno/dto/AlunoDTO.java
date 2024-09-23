package br.com.fiap.ms_aluno.dto;

import br.com.fiap.ms_aluno.model.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

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
}
