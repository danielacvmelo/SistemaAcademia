package com.projeto.academia.service;

import com.projeto.academia.exception.EntidadeNaoEncontradaException;
import com.projeto.academia.model.Aula;
import com.projeto.academia.repository.AulaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AulaService {

    private final AulaRepository aulaRepository;

    public List<Aula> listar() {
        return aulaRepository.findAll();
    }

    public Aula buscarPorId(UUID id) {
        return aulaRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Aula não encontrada com o ID: " + id));
    }

    @Transactional
    public Aula salvar(Aula aula) {
        return aulaRepository.save(aula);
    }

    @Transactional
    public Aula atualizar(UUID id, Aula aula) {
        if (!aulaRepository.existsById(id)) {
            throw new EntidadeNaoEncontradaException("Aula não encontrada com o ID: " + id);
        }
        aula.setId(id);
        return aulaRepository.save(aula);
    }

    @Transactional
    public void excluir(UUID id) {
        if (!aulaRepository.existsById(id)) {
            throw new EntidadeNaoEncontradaException("Aula não encontrada com o ID: " + id);
        }
        aulaRepository.deleteById(id);
    }
}