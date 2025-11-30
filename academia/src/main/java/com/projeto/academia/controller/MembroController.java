package com.projeto.academia.controller;

import com.projeto.academia.model.Membro;
import com.projeto.academia.service.MembroService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/membros")
@RequiredArgsConstructor
public class MembroController {

    private final MembroService membroService;

    @GetMapping
    public ResponseEntity<Page<Membro>> listar(
            @PageableDefault(size = 10, sort = "dataMatricula") Pageable pageable) {
        return ResponseEntity.ok(membroService.listar(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Membro> buscarPorId(@PathVariable UUID id) {
        return ResponseEntity.ok(membroService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Membro> criar(@Valid @RequestBody Membro membro) {
        return ResponseEntity.ok(membroService.salvar(membro));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Membro> atualizar(@PathVariable UUID id, @Valid @RequestBody Membro membro) {
        return ResponseEntity.ok(membroService.atualizar(id, membro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        membroService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}