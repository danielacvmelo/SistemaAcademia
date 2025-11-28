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
    public List<PlanoDeMembresia> listar() {
        return planoService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanoDeMembresia> buscarPorId(@PathVariable UUID id) {
        try {
            return ResponseEntity.ok(planoService.buscarPorId(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<PlanoDeMembresia> criar(@Valid @RequestBody PlanoDeMembresia plano) {
        PlanoDeMembresia planoSalvo = planoService.salvar(plano);
        return ResponseEntity.ok(planoSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlanoDeMembresia> atualizar(@PathVariable UUID id, @Valid @RequestBody PlanoDeMembresia plano) {
        try {
            PlanoDeMembresia planoAtualizado = planoService.atualizar(id, plano);
            return ResponseEntity.ok(planoAtualizado);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        try {
            planoService.excluir(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}