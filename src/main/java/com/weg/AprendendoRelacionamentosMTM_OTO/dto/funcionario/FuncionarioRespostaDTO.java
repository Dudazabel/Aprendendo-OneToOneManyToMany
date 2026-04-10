package com.weg.AprendendoRelacionamentosMTM_OTO.dto.funcionario;

import java.util.List;

public record FuncionarioRespostaDTO(
    Long id,
    String nome,
    String assentoCodigo,
    List<String> nomeProjetos
) {

}
