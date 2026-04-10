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

import com.weg.AprendendoRelacionamentosMTM_OTO.dto.projeto.ProjetoRequisicaoDTO;
import com.weg.AprendendoRelacionamentosMTM_OTO.dto.projeto.ProjetoRespostaDTO;
import com.weg.AprendendoRelacionamentosMTM_OTO.service.ProjetoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/projeto")
@RequiredArgsConstructor
public class ProjetoController {

    private final ProjetoService service;

    @PostMapping
    public ResponseEntity<ProjetoRespostaDTO> cadastrarProjeto(@Valid @RequestBody ProjetoRequisicaoDTO projeto){
        ProjetoRespostaDTO projetoSalvo = service.cadastrarProjeto(projeto);
        return ResponseEntity.status(HttpStatus.CREATED).body(projetoSalvo);
    }

    @GetMapping
    public ResponseEntity<List<ProjetoRespostaDTO>> listarProjetos(){
        return ResponseEntity.ok(service.listarProjetos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjetoRespostaDTO> buscarProjetoPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarProjetoPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjetoRespostaDTO> atualizarProjeto(@Valid @PathVariable Long id, @RequestBody ProjetoRequisicaoDTO projeto){
        return ResponseEntity.ok(service.atualizarProjeto(id, projeto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProjeto(@PathVariable Long id){
        service.deletarProjeto(id);
        return ResponseEntity.noContent().build();
    }
    
}
