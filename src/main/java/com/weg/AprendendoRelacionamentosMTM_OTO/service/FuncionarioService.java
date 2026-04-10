package com.weg.AprendendoRelacionamentosMTM_OTO.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.weg.AprendendoRelacionamentosMTM_OTO.dto.funcionario.FuncionarioRequisicaoDTO;
import com.weg.AprendendoRelacionamentosMTM_OTO.dto.funcionario.FuncionarioRespostaDTO;
import com.weg.AprendendoRelacionamentosMTM_OTO.mapper.FuncionarioMapper;
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

    public FuncionarioRespostaDTO atualizarFuncionario(Long id, FuncionarioRequisicaoDTO funcionario){
        Funcionario funcionarioSalvo = funcionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado!"));
        funcionarioSalvo.setNome(funcionario.nome());
        List<Projeto> projeto = projetoRepository.findAllById(funcionario.idProjetos());
        funcionarioSalvo.setProjetos(projeto);
        funcionarioSalvo.setAssento(assentoRespository.findById(funcionario.idAssento())
                .orElseThrow(() -> new RuntimeException("Assento não encontrado!")));
        return mapper.EntidadeParaDTO(funcionarioRepository.save(funcionarioSalvo));
    }

    public void deletarFuncionario(Long id){
        funcionarioRepository.deleteById(id);
    }
}
