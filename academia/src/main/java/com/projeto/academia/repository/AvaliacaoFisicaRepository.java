package com.projeto.academia.repository;

import com.projeto.academia.model.AvaliacaoFisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AvaliacaoFisicaRepository extends JpaRepository<AvaliacaoFisica, UUID> {
}