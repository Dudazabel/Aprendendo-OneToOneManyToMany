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

import com.weg.AprendendoRelacionamentosMTM_OTO.dto.assento.AssentoRequisicaoDTO;
import com.weg.AprendendoRelacionamentosMTM_OTO.dto.assento.AssentoRespostaDTO;
import com.weg.AprendendoRelacionamentosMTM_OTO.service.AssentoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/assento")
@RequiredArgsConstructor
public class AssentoController {

    private final AssentoService service;
    
    @PostMapping
    public ResponseEntity<AssentoRespostaDTO> cadastrarAssento(@Valid @RequestBody AssentoRequisicaoDTO assento){
        AssentoRespostaDTO assentoSalvo = service.cadastrarAssento(assento);
        return ResponseEntity.status(HttpStatus.CREATED).body(assentoSalvo);
    }

    @GetMapping
    public ResponseEntity<List<AssentoRespostaDTO>> listarAssentos(){
        return ResponseEntity.ok(service.listarAssentos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssentoRespostaDTO> buscarAssentoPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarAssentoPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AssentoRespostaDTO> atualizarAssento(@Valid @PathVariable Long id, @RequestBody AssentoRequisicaoDTO assento){
        return ResponseEntity.ok(service.atualizarAssento(id, assento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAssento(@PathVariable Long id){
        service.deletarAssento(id);
        return ResponseEntity.noContent().build();
    }
}
