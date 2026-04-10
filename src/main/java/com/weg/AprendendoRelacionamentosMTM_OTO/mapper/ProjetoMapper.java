package com.weg.AprendendoRelacionamentosMTM_OTO.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.weg.AprendendoRelacionamentosMTM_OTO.dto.projeto.ProjetoRequisicaoDTO;
import com.weg.AprendendoRelacionamentosMTM_OTO.dto.projeto.ProjetoRespostaDTO;
import com.weg.AprendendoRelacionamentosMTM_OTO.model.Projeto;

@Component
public class ProjetoMapper {
    
    public Projeto DTOParaEntidade(ProjetoRequisicaoDTO projeto){
        return new Projeto(projeto.nome());
    }

    public ProjetoRespostaDTO EntidadeParaDTO(Projeto projeto){
        return new ProjetoRespostaDTO(projeto.getId(), projeto.getNome());
    }

    public List<ProjetoRespostaDTO> EntidadeParaDTOList(List<Projeto> projetos){
        return projetos
            .stream()
            .map(this::EntidadeParaDTO)
            .toList();
    }
}
