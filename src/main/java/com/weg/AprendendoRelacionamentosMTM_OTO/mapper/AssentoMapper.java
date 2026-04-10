package com.weg.AprendendoRelacionamentosMTM_OTO.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.weg.AprendendoRelacionamentosMTM_OTO.dto.assento.AssentoRequisicaoDTO;
import com.weg.AprendendoRelacionamentosMTM_OTO.dto.assento.AssentoRespostaDTO;
import com.weg.AprendendoRelacionamentosMTM_OTO.model.Assento;

@Component
public class AssentoMapper {

    public Assento DTOParaEntidade(AssentoRequisicaoDTO assento){
        return new Assento(assento.codigo());
    }

    public AssentoRespostaDTO EntidadeParaDTO(Assento assento){
        return new AssentoRespostaDTO(assento.getId(), assento.getCodigo());
    }

    public List<AssentoRespostaDTO> EntidadeParaDTOList(List<Assento> assentos){
        return assentos
            .stream()
            .map(this::EntidadeParaDTO)
            .toList();
    }
    
}
