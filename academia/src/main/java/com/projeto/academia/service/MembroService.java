package com.projeto.academia.service;

import com.projeto.academia.exception.EntidadeNaoEncontradaException;
import com.projeto.academia.model.Membro;
import com.projeto.academia.repository.MembroRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MembroService {

    private final MembroRepository membroRepository;

    public Page<Membro> listar(Pageable pageable) {
        return membroRepository.findAll(pageable);
    }

    // NOVO MÉTODO
    public List<Membro> buscarMatriculadosApos(LocalDate data) {
        return membroRepository.findByDataMatriculaAfter(data);
    }

    public Membro buscarPorId(UUID id) {
        return membroRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Membro não encontrado com o ID: " + id));
    }

    @Transactional
    public Membro salvar(Membro membro) {
        return membroRepository.save(membro);
    }

    @Transactional
    public Membro atualizar(UUID id, Membro membro) {
        if (!membroRepository.existsById(id)) {
            throw new EntidadeNaoEncontradaException("Membro não encontrado com o ID: " + id);
        }
        membro.setId(id);
        return membroRepository.save(membro);
    }

    @Transactional
    public void excluir(UUID id) {
        if (!membroRepository.existsById(id)) {
            throw new EntidadeNaoEncontradaException("Membro não encontrado com o ID: " + id);
        }
        membroRepository.deleteById(id);
    }
}