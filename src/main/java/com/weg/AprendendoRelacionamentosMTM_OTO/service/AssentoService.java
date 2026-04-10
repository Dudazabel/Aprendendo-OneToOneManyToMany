package com.weg.AprendendoRelacionamentosMTM_OTO.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.weg.AprendendoRelacionamentosMTM_OTO.dto.assento.AssentoRequisicaoDTO;
import com.weg.AprendendoRelacionamentosMTM_OTO.dto.assento.AssentoRespostaDTO;
import com.weg.AprendendoRelacionamentosMTM_OTO.mapper.AssentoMapper;
import com.weg.AprendendoRelacionamentosMTM_OTO.model.Assento;
import com.weg.AprendendoRelacionamentosMTM_OTO.repository.AssentoRespository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AssentoService {

    private final AssentoRespository respository;
    private final AssentoMapper mapper;

    public AssentoRespostaDTO cadastrarAssento(AssentoRequisicaoDTO assento){
        Assento assentoSalvo = mapper.DTOParaEntidade(assento);
        return mapper.EntidadeParaDTO(respository.save(assentoSalvo));
    }

    public List<AssentoRespostaDTO> listarAssentos(){
        return mapper.EntidadeParaDTOList(respository.findAll());
    }

    public AssentoRespostaDTO buscarAssentoPorId(Long id){
        return mapper.EntidadeParaDTO(respository.findById(id)
            .orElseThrow(() -> new RuntimeException("Assento não encontrado!")));
    }

    public AssentoRespostaDTO atualizarAssento(Long id, AssentoRequisicaoDTO assento){
        Assento assentoSalvo = respository.findById(id)
                .orElseThrow(() -> new RuntimeException("Assento não encontrado!"));
        assentoSalvo.setCodigo(assento.codigo());
        return mapper.EntidadeParaDTO(respository.save(assentoSalvo));
    }

    public void deletarAssento(Long id){
        respository.deleteById(id);
    }
    
}
