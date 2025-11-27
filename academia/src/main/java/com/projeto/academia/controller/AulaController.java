package com.projeto.academia.controller;

import com.projeto.academia.model.Aula;
import com.projeto.academia.service.AulaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aulas")
@RequiredArgsConstructor
public class AulaController {

    private final AulaService aulaService;

    @GetMapping
    public List<Aula> listar() {
        return aulaService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aula> buscarPorId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(aulaService.buscarPorId(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Aula> criar(@Valid @RequestBody Aula aula) {
        Aula aulaSalva = aulaService.salvar(aula);
        return ResponseEntity.ok(aulaSalva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aula> atualizar(@PathVariable Long id, @Valid @RequestBody Aula aula) {
        try {
            Aula aulaAtualizada = aulaService.atualizar(id, aula);
            return ResponseEntity.ok(aulaAtualizada);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        try {
            aulaService.excluir(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}