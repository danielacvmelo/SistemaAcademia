package com.projeto.academia.service;

import com.projeto.academia.exception.EntidadeNaoEncontradaException;
import com.projeto.academia.model.AvaliacaoFisica;
import com.projeto.academia.repository.AvaliacaoFisicaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AvaliacaoFisicaService {

    private final AvaliacaoFisicaRepository avaliacaoRepository;

    public List<AvaliacaoFisica> listar() {
        return avaliacaoRepository.findAll();
    }

    public AvaliacaoFisica buscarPorId(Long id) {
        return avaliacaoRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Avaliação Física não encontrada com o ID: " + id));
    }

    @Transactional
    public AvaliacaoFisica salvar(AvaliacaoFisica avaliacao) {
        return avaliacaoRepository.save(avaliacao);
    }

    @Transactional
    public AvaliacaoFisica atualizar(Long id, AvaliacaoFisica avaliacao) {
        if (!avaliacaoRepository.existsById(id)) {
            throw new EntidadeNaoEncontradaException("Avaliação Física não encontrada com o ID: " + id);
        }
        avaliacao.setId(id);
        return avaliacaoRepository.save(avaliacao);
    }

    @Transactional
    public void excluir(Long id) {
        if (!avaliacaoRepository.existsById(id)) {
            throw new EntidadeNaoEncontradaException("Avaliação Física não encontrada com o ID: " + id);
        }
        avaliacaoRepository.deleteById(id);
    }
}