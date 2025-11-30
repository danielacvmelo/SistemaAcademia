package com.projeto.academia.controller;

import com.projeto.academia.model.Instrutor;
import com.projeto.academia.service.InstrutorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/instrutores")
@RequiredArgsConstructor
public class InstrutorController {

    private final InstrutorService instrutorService;

    @GetMapping
    public ResponseEntity<List<Instrutor>> listar() {
        return ResponseEntity.ok(instrutorService.listar());
    }

    // NOVO ENDPOINT
    @GetMapping("/filtro")
    public ResponseEntity<List<Instrutor>> filtrarPorEspecialidade(@RequestParam String especialidade) {
        return ResponseEntity.ok(instrutorService.filtrarPorEspecialidade(especialidade));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instrutor> buscarPorId(@PathVariable UUID id) {
        return ResponseEntity.ok(instrutorService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Instrutor> criar(@Valid @RequestBody Instrutor instrutor) {
        return ResponseEntity.ok(instrutorService.salvar(instrutor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Instrutor> atualizar(@PathVariable UUID id, @Valid @RequestBody Instrutor instrutor) {
        return ResponseEntity.ok(instrutorService.atualizar(id, instrutor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        instrutorService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}