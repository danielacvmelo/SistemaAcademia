package com.projeto.academia.controller;

import com.projeto.academia.model.Membro;
import com.projeto.academia.service.MembroService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/membros")
@RequiredArgsConstructor
public class MembroController {

    private final MembroService membroService;

    @GetMapping
    public List<Membro> listar() {
        return membroService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Membro> buscarPorId(@PathVariable UUID id) {
        try {
            return ResponseEntity.ok(membroService.buscarPorId(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Membro> criar(@Valid @RequestBody Membro membro) {
        Membro membroSalvo = membroService.salvar(membro);
        return ResponseEntity.ok(membroSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Membro> atualizar(@PathVariable UUID id, @Valid @RequestBody Membro membro) {
        try {
            Membro membroAtualizado = membroService.atualizar(id, membro);
            return ResponseEntity.ok(membroAtualizado);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        try {
            membroService.excluir(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}