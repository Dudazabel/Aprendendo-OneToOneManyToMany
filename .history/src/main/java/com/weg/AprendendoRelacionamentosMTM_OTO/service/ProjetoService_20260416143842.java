package com.weg.AprendendoRelacionamentosMTM_OTO.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.weg.AprendendoRelacionamentosMTM_OTO.dto.projeto.ProjetoRequisicaoDTO;
import com.weg.AprendendoRelacionamentosMTM_OTO.dto.projeto.ProjetoRespostaDTO;
import com.weg.AprendendoRelacionamentosMTM_OTO.mapper.ProjetoMapper;
import com.weg.AprendendoRelacionamentosMTM_OTO.model.Funcionario;
import com.weg.AprendendoRelacionamentosMTM_OTO.model.Projeto;
import com.weg.AprendendoRelacionamentosMTM_OTO.repository.FuncionarioRepository;
import com.weg.AprendendoRelacionamentosMTM_OTO.repository.ProjetoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjetoService {

    private final ProjetoRepository projetoRepository;
    private final FuncionarioRepository funcionarioRepository;
    private final ProjetoMapper mapper;

    public ProjetoRespostaDTO cadastrarProjeto(ProjetoRequisicaoDTO projeto){
        Projeto projetoSalvo = mapper.DTOParaEntidade(projeto);
        return mapper.EntidadeParaDTO(projetoRepository.save(projetoSalvo));
    }

    public List<ProjetoRespostaDTO> listarProjetos(){
        return mapper.EntidadeParaDTOList(projetoRepository.findAll());
    }

    public ProjetoRespostaDTO buscarProjetoPorId(Long id){
        return mapper.EntidadeParaDTO(projetoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado!")));
    }

    public ProjetoRespostaDTO atualizarProjeto(Long id, ProjetoRequisicaoDTO projeto){
        Projeto projetoSalvo = projetoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado!"));
        projetoSalvo.setNome(projeto.nome());
        projetoSalvo.setFuncionarios(funcionario);
        return mapper.EntidadeParaDTO(projetoRepository.save(projetoSalvo));
    }

    public void deletarProjeto(Long id){
        projetoRepository.deleteById(id);
    }
    
}
