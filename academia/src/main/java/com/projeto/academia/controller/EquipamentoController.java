package com.projeto.academia.controller;

import com.projeto.academia.model.Equipamento;
import com.projeto.academia.service.EquipamentoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/equipamentos")
@RequiredArgsConstructor
public class EquipamentoController {

    private final EquipamentoService equipamentoService;

    @GetMapping
    public List<Equipamento> listar() {
        return equipamentoService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipamento> buscarPorId(@PathVariable UUID id) {
        try {
            return ResponseEntity.ok(equipamentoService.buscarPorId(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Equipamento> criar(@Valid @RequestBody Equipamento equipamento) {
        Equipamento equipamentoSalvo = equipamentoService.salvar(equipamento);
        return ResponseEntity.ok(equipamentoSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipamento> atualizar(@PathVariable UUID id, @Valid @RequestBody Equipamento equipamento) {
        try {
            Equipamento equipamentoAtualizado = equipamentoService.atualizar(id, equipamento);
            return ResponseEntity.ok(equipamentoAtualizado);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        try {
            equipamentoService.excluir(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}