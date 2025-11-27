package com.projeto.academia.controller;

import com.projeto.academia.model.Instrutor;
import com.projeto.academia.service.InstrutorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instrutores")
@RequiredArgsConstructor
public class InstrutorController {

    private final InstrutorService instrutorService;

    @GetMapping
    public List<Instrutor> listar() {
        return instrutorService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instrutor> buscarPorId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(instrutorService.buscarPorId(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Instrutor> criar(@Valid @RequestBody Instrutor instrutor) {
        Instrutor instrutorSalvo = instrutorService.salvar(instrutor);
        return ResponseEntity.ok(instrutorSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Instrutor> atualizar(@PathVariable Long id, @Valid @RequestBody Instrutor instrutor) {
        try {
            Instrutor instrutorAtualizado = instrutorService.atualizar(id, instrutor);
            return ResponseEntity.ok(instrutorAtualizado);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        try {
            instrutorService.excluir(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}