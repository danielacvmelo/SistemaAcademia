package com.projeto.academia.service;

import com.projeto.academia.exception.EntidadeNaoEncontradaException;
import com.projeto.academia.model.PlanoDeMembresia;
import com.projeto.academia.repository.PlanoDeMembresiaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PlanoDeMembresiaService {

    private final PlanoDeMembresiaRepository planoRepository;

    public List<PlanoDeMembresia> listar() {
        return planoRepository.findAll();
    }

    public PlanoDeMembresia buscarPorId(UUID id) {
        return planoRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Plano de Membresia não encontrado com o ID: " + id));
    }

    @Transactional
    public PlanoDeMembresia salvar(PlanoDeMembresia plano) {
        return planoRepository.save(plano);
    }

    @Transactional
    public PlanoDeMembresia atualizar(UUID id, PlanoDeMembresia plano) {
        if (!planoRepository.existsById(id)) {
            throw new EntidadeNaoEncontradaException("Plano de Membresia não encontrado com o ID: " + id);
        }
        plano.setId(id);
        return planoRepository.save(plano);
    }

    @Transactional
    public void excluir(UUID id) {
        if (!planoRepository.existsById(id)) {
            throw new EntidadeNaoEncontradaException("Plano de Membresia não encontrado com o ID: " + id);
        }
        planoRepository.deleteById(id);
    }
}