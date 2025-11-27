package com.projeto.academia.service;

import com.projeto.academia.exception.EntidadeNaoEncontradaException;
import com.projeto.academia.model.Membro;
import com.projeto.academia.repository.MembroRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MembroService {

    private final MembroRepository membroRepository;

    public List<Membro> listar() {
        return membroRepository.findAll();
    }

    public Membro buscarPorId(Long id) {
        return membroRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Membro não encontrado com o ID: " + id));
    }

    @Transactional
    public Membro salvar(Membro membro) {
        return membroRepository.save(membro);
    }

    @Transactional
    public Membro atualizar(Long id, Membro membro) {
        if (!membroRepository.existsById(id)) {
            throw new EntidadeNaoEncontradaException("Membro não encontrado com o ID: " + id);
        }
        membro.setId(id);
        return membroRepository.save(membro);
    }

    @Transactional
    public void excluir(Long id) {
        if (!membroRepository.existsById(id)) {
            throw new EntidadeNaoEncontradaException("Membro não encontrado com o ID: " + id);
        }
        membroRepository.deleteById(id);
    }
}