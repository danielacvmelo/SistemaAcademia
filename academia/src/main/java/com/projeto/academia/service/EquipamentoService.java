package com.projeto.academia.service;

import com.projeto.academia.exception.EntidadeNaoEncontradaException;
import com.projeto.academia.model.Equipamento;
import com.projeto.academia.repository.EquipamentoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipamentoService {

    private final EquipamentoRepository equipamentoRepository;

    public List<Equipamento> listar() {
        return equipamentoRepository.findAll();
    }

    public Equipamento buscarPorId(Long id) {
        return equipamentoRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Equipamento não encontrado com o ID: " + id));
    }

    @Transactional
    public Equipamento salvar(Equipamento equipamento) {
        return equipamentoRepository.save(equipamento);
    }

    @Transactional
    public Equipamento atualizar(Long id, Equipamento equipamento) {
        if (!equipamentoRepository.existsById(id)) {
            throw new EntidadeNaoEncontradaException("Equipamento não encontrado com o ID: " + id);
        }
        equipamento.setId(id);
        return equipamentoRepository.save(equipamento);
    }

    @Transactional
    public void excluir(Long id) {
        if (!equipamentoRepository.existsById(id)) {
            throw new EntidadeNaoEncontradaException("Equipamento não encontrado com o ID: " + id);
        }
        equipamentoRepository.deleteById(id);
    }
}