package com.projeto.academia.controller;

import com.projeto.academia.model.AvaliacaoFisica;
import com.projeto.academia.service.AvaliacaoFisicaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/avaliacoes-fisicas")
@RequiredArgsConstructor
public class AvaliacaoFisicaController {

    private final AvaliacaoFisicaService avaliacaoService;

    @GetMapping
    public ResponseEntity<List<AvaliacaoFisica>> listar() {
        return ResponseEntity.ok(avaliacaoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AvaliacaoFisica> buscarPorId(@PathVariable UUID id) {
        return ResponseEntity.ok(avaliacaoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<AvaliacaoFisica> criar(@Valid @RequestBody AvaliacaoFisica avaliacao) {
        return ResponseEntity.ok(avaliacaoService.salvar(avaliacao));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AvaliacaoFisica> atualizar(@PathVariable UUID id, @Valid @RequestBody AvaliacaoFisica avaliacao) {
        return ResponseEntity.ok(avaliacaoService.atualizar(id, avaliacao));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        avaliacaoService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}