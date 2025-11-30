package com.projeto.academia.service;

import com.projeto.academia.exception.EntidadeNaoEncontradaException;
import com.projeto.academia.model.Instrutor;
import com.projeto.academia.repository.InstrutorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InstrutorService {

    private final InstrutorRepository instrutorRepository;

    public List<Instrutor> listar() {
        return instrutorRepository.findAll();
    }

    // NOVO MÉTODO
    public List<Instrutor> filtrarPorEspecialidade(String especialidade) {
        return instrutorRepository.findByEspecialidadeContainingIgnoreCase(especialidade);
    }

    public Instrutor buscarPorId(UUID id) {
        return instrutorRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Instrutor não encontrado com o ID: " + id));
    }

    @Transactional
    public Instrutor salvar(Instrutor instrutor) {
        return instrutorRepository.save(instrutor);
    }

    @Transactional
    public Instrutor atualizar(UUID id, Instrutor instrutor) {
        if (!instrutorRepository.existsById(id)) {
            throw new EntidadeNaoEncontradaException("Instrutor não encontrado com o ID: " + id);
        }
        instrutor.setId(id);
        return instrutorRepository.save(instrutor);
    }

    @Transactional
    public void excluir(UUID id) {
        if (!instrutorRepository.existsById(id)) {
            throw new EntidadeNaoEncontradaException("Instrutor não encontrado com o ID: " + id);
        }
        instrutorRepository.deleteById(id);
    }
}