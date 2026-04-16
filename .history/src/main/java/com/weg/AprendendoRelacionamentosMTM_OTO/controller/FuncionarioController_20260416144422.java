package com.weg.AprendendoRelacionamentosMTM_OTO.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weg.AprendendoRelacionamentosMTM_OTO.dto.funcionario.FuncionarioComAssentoDTO;
import com.weg.AprendendoRelacionamentosMTM_OTO.dto.funcionario.FuncionarioRequisicaoDTO;
import com.weg.AprendendoRelacionamentosMTM_OTO.dto.funcionario.FuncionarioRespostaDTO;
import com.weg.AprendendoRelacionamentosMTM_OTO.service.FuncionarioService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/funcionario")
@RequiredArgsConstructor
public class FuncionarioController {

    private final FuncionarioService service;

    @PostMapping
    public ResponseEntity<FuncionarioRespostaDTO> cadastrarFuncionario(@Valid @RequestBody FuncionarioRequisicaoDTO funcionario){
        FuncionarioRespostaDTO funcionarioSalvo = service.cadastrarFunconario(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioSalvo);
    }

    @GetMapping
    public ResponseEntity<List<FuncionarioRespostaDTO>> listarFuncionarios(){
        return ResponseEntity.ok(service.listarFuncionarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioRespostaDTO> buscarFuncionarioPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarFuncionarioPorId(id));
    }

    @PutMapping("/funcionario/{idFuncionario}/assento/{idAssento}")
   public ResponseEntity<FuncionarioComAssentoDTO> associarAssentoFuncionario(@PathVariable Long idFuncionario, @PathVariable Long idAssento){
    return ResponseEntity.status(HttpStatus.OK).body(service.as)
   }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFuncionario(@PathVariable Long id){
        service.deletarFuncionario(id);
        return ResponseEntity.noContent().build();
    }
    
}
