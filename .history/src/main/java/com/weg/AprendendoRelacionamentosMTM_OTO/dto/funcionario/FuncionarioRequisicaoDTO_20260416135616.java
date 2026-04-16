package com.weg.AprendendoRelacionamentosMTM_OTO.dto.funcionario;

import jakarta.validation.constraints.NotBlank;

public record FuncionarioRequisicaoDTO(
    @NotBlank
    String nome
) {

}
