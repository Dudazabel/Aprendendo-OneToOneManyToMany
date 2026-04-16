package com.weg.AprendendoRelacionamentosMTM_OTO.dto.funcionario;

import java.util.List;

import com.weg.AprendendoRelacionamentosMTM_OTO.dto.projeto.ProjetoRespostaDTO;

public record FuncionarioProjetoRespostaDTO(
    FuncionarioRespostaDTO funcionario,
    List<ProjetoRespostaDTO> projetos
) {

}
