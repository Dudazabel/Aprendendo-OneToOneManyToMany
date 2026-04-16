package com.weg.AprendendoRelacionamentosMTM_OTO.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.weg.AprendendoRelacionamentosMTM_OTO.dto.assento.AssentoRespostaDTO;
import com.weg.AprendendoRelacionamentosMTM_OTO.dto.funcionario.FuncionarioComAssentoDTO;
import com.weg.AprendendoRelacionamentosMTM_OTO.dto.funcionario.FuncionarioProjetoRespostaDTO;
import com.weg.AprendendoRelacionamentosMTM_OTO.dto.funcionario.FuncionarioRequisicaoDTO;
import com.weg.AprendendoRelacionamentosMTM_OTO.dto.funcionario.FuncionarioRespostaDTO;
import com.weg.AprendendoRelacionamentosMTM_OTO.dto.projeto.ProjetoRespostaDTO;
import com.weg.AprendendoRelacionamentosMTM_OTO.model.Funcionario;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FuncionarioMapper {

    private final ProjetoMapper projetoMapper;

    private final AssentoMapper assentoMapper;
    
    public Funcionario DTOParaEntidade(FuncionarioRequisicaoDTO funcionario){
        return new Funcionario(funcionario.nome());
    }

    public FuncionarioRespostaDTO EntidadeParaDTO(Funcionario funcionario){
        return new FuncionarioRespostaDTO(funcionario.getId(), funcionario.getNome());
    }

    public List<FuncionarioRespostaDTO> EntidadeParaDTOList(List<Funcionario> funcionarios){
        return funcionarios
            .stream()
            .map(this::EntidadeParaDTO)
            .toList();
    }

    public FuncionarioComAssentoDTO FuncionarioComAssentoRespostaDTO(Funcionario funcionario){
        AssentoRespostaDTO assentoRespostaDTO = assentoMapper.EntidadeParaDTO(funcionario.getAssento());

        FuncionarioRespostaDTO funcionarioRespostaDTO = EntidadeParaDTO(funcionario);

        return new FuncionarioComAssentoDTO(
            funcionarioRespostaDTO,
            assentoRespostaDTO
        );
    }

    public FuncionarioProjetoRespostaDTO funcionarioProjetoRespostaDTO(Funcionario funcionario){
        List<ProjetoRespostaDTO> projetos = funcionario
    }
}
