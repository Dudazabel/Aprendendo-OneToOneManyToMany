package com.weg.AprendendoRelacionamentosMTM_OTO.dto.funcionario;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record FuncionarioRequisicaoDTO(
    @NotBlank
    String nome
) {

}
