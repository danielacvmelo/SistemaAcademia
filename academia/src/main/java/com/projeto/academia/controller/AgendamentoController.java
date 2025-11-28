package com.projeto.academia.controller;

import com.projeto.academia.model.Agendamento;
import com.projeto.academia.service.AgendamentoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/agendamentos")
@RequiredArgsConstructor
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    @GetMapping
    public List<Agendamento> listar() {
        return agendamentoService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agendamento> buscarPorId(@PathVariable UUID id) {
        try {
            return ResponseEntity.ok(agendamentoService.buscarPorId(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Agendamento> criar(@Valid @RequestBody Agendamento agendamento) {
        Agendamento agendamentoSalvo = agendamentoService.salvar(agendamento);
        return ResponseEntity.ok(agendamentoSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agendamento> atualizar(@PathVariable UUID id, @Valid @RequestBody Agendamento agendamento) {
        try {
            Agendamento agendamentoAtualizado = agendamentoService.atualizar(id, agendamento);
            return ResponseEntity.ok(agendamentoAtualizado);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        try {
            agendamentoService.excluir(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}