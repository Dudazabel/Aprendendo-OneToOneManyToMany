package com.weg.AprendendoRelacionamentosMTM_OTO.dto.funcionario;

import com.weg.AprendendoRelacionamentosMTM_OTO.dto.assento.AssentoRespostaDTO;

public record FuncionarioComAssentoDTO(
    FuncionarioRespostaDTO funcionario,
    AssentoRespostaDTO assento
) {

}
