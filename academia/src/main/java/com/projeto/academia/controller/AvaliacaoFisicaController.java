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
    public List<AvaliacaoFisica> listar() {
        return avaliacaoService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AvaliacaoFisica> buscarPorId(@PathVariable UUID id) {
        try {
            return ResponseEntity.ok(avaliacaoService.buscarPorId(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<AvaliacaoFisica> criar(@Valid @RequestBody AvaliacaoFisica avaliacao) {
        AvaliacaoFisica avaliacaoSalva = avaliacaoService.salvar(avaliacao);
        return ResponseEntity.ok(avaliacaoSalva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AvaliacaoFisica> atualizar(@PathVariable UUID id, @Valid @RequestBody AvaliacaoFisica avaliacao) {
        try {
            AvaliacaoFisica avaliacaoAtualizada = avaliacaoService.atualizar(id, avaliacao);
            return ResponseEntity.ok(avaliacaoAtualizada);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        try {
            avaliacaoService.excluir(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}