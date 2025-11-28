package com.projeto.academia.service;

import com.projeto.academia.exception.EntidadeNaoEncontradaException;
import com.projeto.academia.model.Agendamento;
import com.projeto.academia.repository.AgendamentoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;

    public List<Agendamento> listar() {
        return agendamentoRepository.findAll();
    }

    public Agendamento buscarPorId(UUID id) {
        return agendamentoRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Agendamento não encontrado com o ID: " + id));
    }

    @Transactional
    public Agendamento salvar(Agendamento agendamento) {
        return agendamentoRepository.save(agendamento);
    }

    @Transactional
    public Agendamento atualizar(UUID id, Agendamento agendamento) {
        if (!agendamentoRepository.existsById(id)) {
            throw new EntidadeNaoEncontradaException("Agendamento não encontrado com o ID: " + id);
        }
        agendamento.setId(id);
        return agendamentoRepository.save(agendamento);
    }

    @Transactional
    public void excluir(UUID id) {
        if (!agendamentoRepository.existsById(id)) {
            throw new EntidadeNaoEncontradaException("Agendamento não encontrado com o ID: " + id);
        }
        agendamentoRepository.deleteById(id);
    }
}