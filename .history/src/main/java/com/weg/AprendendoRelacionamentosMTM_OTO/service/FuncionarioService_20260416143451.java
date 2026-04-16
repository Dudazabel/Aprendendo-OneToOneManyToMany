package com.weg.AprendendoRelacionamentosMTM_OTO.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.weg.AprendendoRelacionamentosMTM_OTO.dto.funcionario.FuncionarioComAssentoDTO;
import com.weg.AprendendoRelacionamentosMTM_OTO.dto.funcionario.FuncionarioProjetoRespostaDTO;
import com.weg.AprendendoRelacionamentosMTM_OTO.dto.funcionario.FuncionarioRequisicaoDTO;
import com.weg.AprendendoRelacionamentosMTM_OTO.dto.funcionario.FuncionarioRespostaDTO;
import com.weg.AprendendoRelacionamentosMTM_OTO.mapper.FuncionarioMapper;
import com.weg.AprendendoRelacionamentosMTM_OTO.model.Assento;
import com.weg.AprendendoRelacionamentosMTM_OTO.model.Funcionario;
import com.weg.AprendendoRelacionamentosMTM_OTO.model.Projeto;
import com.weg.AprendendoRelacionamentosMTM_OTO.repository.AssentoRespository;
import com.weg.AprendendoRelacionamentosMTM_OTO.repository.FuncionarioRepository;
import com.weg.AprendendoRelacionamentosMTM_OTO.repository.ProjetoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FuncionarioService {
    
    private final FuncionarioRepository funcionarioRepository;
    private final AssentoRespository assentoRespository;
    private final ProjetoRepository projetoRepository;
    private final FuncionarioMapper mapper;

    public FuncionarioRespostaDTO cadastrarFunconario(FuncionarioRequisicaoDTO funcionario){
        Funcionario funcionarioSalvo = mapper.DTOParaEntidade(funcionario);
        return mapper.EntidadeParaDTO(funcionarioRepository.save(funcionarioSalvo));
    }

    public List<FuncionarioRespostaDTO> listarFuncionarios(){
        return mapper.EntidadeParaDTOList(funcionarioRepository.findAll());
    }

    public FuncionarioRespostaDTO buscarFuncionarioPorId(Long id){
        return mapper.EntidadeParaDTO(funcionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado!")));
    }

    public FuncionarioComAssentoDTO associarFuncionarioAssento(Long idFuncionario, Long idAssento){

        Funcionario funcionario = funcionarioRepository.findById(idFuncionario)
        .orElseThrow(() -> new RuntimeException("Funcionário não existe!"));

        Assento assento = assentoRespository.findById(idAssento)
        .orElseThrow(() -> new RuntimeException("Assento não existe!"));

        funcionario.setAssento(assento);

        return mapper.FuncionarioComAssentoRespostaDTO(funcionarioRepository.save(funcionario));
    }

    public FuncionarioProjetoRespostaDTO associarFuncionarioProjeto(Long idFuncionario, Long idProjeto){
        Funcionario funcionario = funcionarioRepository.findById(idFuncionario)
        .orElseThrow(() -> new RuntimeException(""))
    }

    public void deletarFuncionario(Long id){
        funcionarioRepository.deleteById(id);
    }


}
