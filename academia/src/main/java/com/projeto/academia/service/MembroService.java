package com.projeto.academia.service;

import com.projeto.academia.exception.EntidadeNaoEncontradaException;
import com.projeto.academia.model.Membro;
import com.projeto.academia.model.PlanoDeMembresia;
import com.projeto.academia.model.Usuario;
import com.projeto.academia.repository.MembroRepository;
import com.projeto.academia.repository.PlanoDeMembresiaRepository;
import com.projeto.academia.repository.UsuarioRepository;
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
    private final UsuarioRepository usuarioRepository;
    private final PlanoDeMembresiaRepository planoRepository;

    public Page<Membro> listar(Pageable pageable) {
        return membroRepository.findAll(pageable);
    }

    public List<Membro> buscarMatriculadosApos(LocalDate data) {
        return membroRepository.findByDataMatriculaAfter(data);
    }

    public Membro buscarPorId(UUID id) {
        return membroRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Membro não encontrado com o ID: " + id));
    }

    @Transactional
    public Membro salvar(Membro membro) {
        Usuario usuario = usuarioRepository.findById(membro.getUsuario().getId())
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Usuário não encontrado com o ID: " + membro.getUsuario().getId()));

        if (membro.getPlano() != null && membro.getPlano().getId() != null) {
            PlanoDeMembresia plano = planoRepository.findById(membro.getPlano().getId())
                    .orElseThrow(() -> new EntidadeNaoEncontradaException("Plano não encontrado com o ID: " + membro.getPlano().getId()));
            membro.setPlano(plano);
        }

        membro.setUsuario(usuario);

        return membroRepository.save(membro);
    }

    @Transactional
    public Membro atualizar(UUID id, Membro membroAtualizado) {
        Membro membroExistente = buscarPorId(id);

        if (membroAtualizado.getPlano() != null && membroAtualizado.getPlano().getId() != null) {
            PlanoDeMembresia plano = planoRepository.findById(membroAtualizado.getPlano().getId())
                    .orElseThrow(() -> new EntidadeNaoEncontradaException("Plano não encontrado com o ID: " + membroAtualizado.getPlano().getId()));
            membroExistente.setPlano(plano);
        }

        if (membroAtualizado.getDataMatricula() != null) {
            membroExistente.setDataMatricula(membroAtualizado.getDataMatricula());
        }

        if (membroAtualizado.getStatus() != null) {
            membroExistente.setStatus(membroAtualizado.getStatus());
        }

        return membroRepository.save(membroExistente);
    }

    @Transactional
    public void excluir(UUID id) {
        Membro membro = buscarPorId(id);
        membroRepository.delete(membro);
    }
}
