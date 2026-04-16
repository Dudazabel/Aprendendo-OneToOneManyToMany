package com.weg.AprendendoRelacionamentosMTM_OTO.dto.projeto;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProjetoRequisicaoDTO(
    @NotBlank 
    String nome,

    @NotNull
    List<Long> idFuncionario
) {

}
