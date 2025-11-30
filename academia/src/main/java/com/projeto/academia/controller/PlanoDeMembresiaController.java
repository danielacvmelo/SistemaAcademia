package com.projeto.academia.controller;

import com.projeto.academia.model.PlanoDeMembresia;
import com.projeto.academia.service.PlanoDeMembresiaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/planos")
@RequiredArgsConstructor
public class PlanoDeMembresiaController {

    private final PlanoDeMembresiaService planoService;

    @GetMapping
    public ResponseEntity<List<PlanoDeMembresia>> listar() {
        return ResponseEntity.ok(planoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanoDeMembresia> buscarPorId(@PathVariable UUID id) {
        return ResponseEntity.ok(planoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<PlanoDeMembresia> criar(@Valid @RequestBody PlanoDeMembresia plano) {
        return ResponseEntity.ok(planoService.salvar(plano));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlanoDeMembresia> atualizar(@PathVariable UUID id, @Valid @RequestBody PlanoDeMembresia plano) {
        return ResponseEntity.ok(planoService.atualizar(id, plano));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        planoService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}