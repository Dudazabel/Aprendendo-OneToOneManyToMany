package com.weg.AprendendoRelacionamentosMTM_OTO.dto.projeto;

import java.util.List;

import jakarta.validation.constraints.NotBlank;

public record ProjetoRequisicaoDTO(
    @NotBlank 
    String nome
) {

}
