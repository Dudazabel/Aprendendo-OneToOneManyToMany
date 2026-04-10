package com.weg.AprendendoRelacionamentosMTM_OTO.dto.assento;

import jakarta.validation.constraints.NotBlank;

public record AssentoRequisicaoDTO(
    @NotBlank
    String codigo
) {

}
