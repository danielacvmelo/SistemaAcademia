package com.projeto.academia.service;

import com.projeto.academia.exception.EntidadeNaoEncontradaException;
import com.projeto.academia.model.PlanoDeMembresia;
import com.projeto.academia.repository.PlanoDeMembresiaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlanoDeMembresiaService {

    private final PlanoDeMembresiaRepository planoRepository;

    public List<PlanoDeMembresia> listar() {
        return planoRepository.findAll();
    }

    public PlanoDeMembresia buscarPorId(Long id) {
        return planoRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Plano de Membresia não encontrado com o ID: " + id));
    }

    @Transactional
    public PlanoDeMembresia salvar(PlanoDeMembresia plano) {
        return planoRepository.save(plano);
    }

    @Transactional
    public PlanoDeMembresia atualizar(Long id, PlanoDeMembresia plano) {
        if (!planoRepository.existsById(id)) {
            throw new EntidadeNaoEncontradaException("Plano de Membresia não encontrado com o ID: " + id);
        }
        plano.setId(id);
        return planoRepository.save(plano);
    }

    @Transactional
    public void excluir(Long id) {
        if (!planoRepository.existsById(id)) {
            throw new EntidadeNaoEncontradaException("Plano de Membresia não encontrado com o ID: " + id);
        }
        planoRepository.deleteById(id);
    }
}