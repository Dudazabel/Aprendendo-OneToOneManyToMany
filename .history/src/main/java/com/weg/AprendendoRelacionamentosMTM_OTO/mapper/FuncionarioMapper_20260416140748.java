package com.weg.AprendendoRelacionamentosMTM_OTO.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.weg.AprendendoRelacionamentosMTM_OTO.dto.assento.AssentoRespostaDTO;
import com.weg.AprendendoRelacionamentosMTM_OTO.dto.funcionario.FuncionarioComAssentoDTO;
import com.weg.AprendendoRelacionamentosMTM_OTO.dto.funcionario.FuncionarioRequisicaoDTO;
import com.weg.AprendendoRelacionamentosMTM_OTO.dto.funcionario.FuncionarioRespostaDTO;
import com.weg.AprendendoRelacionamentosMTM_OTO.model.Funcionario;

@Component
public class FuncionarioMapper {
    
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
        AssentoRespostaDTO assentoRespostaDTO = assentoM
    }
}
