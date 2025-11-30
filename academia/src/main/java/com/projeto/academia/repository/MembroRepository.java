package com.projeto.academia.repository;

import com.projeto.academia.model.Membro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface MembroRepository extends JpaRepository<Membro, UUID> {

    List<Membro> findByDataMatriculaAfter(LocalDate data);

    @Query("SELECT m FROM Membro m WHERE m.status = 'ATIVO'")
    List<Membro> buscarSomenteAtivos();
}