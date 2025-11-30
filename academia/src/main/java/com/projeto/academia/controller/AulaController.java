package com.projeto.academia.controller;

import com.projeto.academia.model.Aula;
import com.projeto.academia.service.AulaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/aulas")
@RequiredArgsConstructor
public class AulaController {

    private final AulaService aulaService;

    @GetMapping
    public ResponseEntity<List<Aula>> listar() {
        return ResponseEntity.ok(aulaService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aula> buscarPorId(@PathVariable UUID id) {
        return ResponseEntity.ok(aulaService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Aula> criar(@Valid @RequestBody Aula aula) {
        return ResponseEntity.ok(aulaService.salvar(aula));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aula> atualizar(@PathVariable UUID id, @Valid @RequestBody Aula aula) {
        return ResponseEntity.ok(aulaService.atualizar(id, aula));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        aulaService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}