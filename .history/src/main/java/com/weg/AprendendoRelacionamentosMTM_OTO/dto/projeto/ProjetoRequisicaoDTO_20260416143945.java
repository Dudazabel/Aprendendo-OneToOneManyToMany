package com.weg.AprendendoRelacionamentosMTM_OTO.dto.projeto;

import jakarta.validation.constraints.NotBlank;

public record ProjetoRequisicaoDTO(
    @NotBlank 
    String nome
) {

}
