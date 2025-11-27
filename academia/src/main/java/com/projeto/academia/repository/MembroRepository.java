package com.projeto.academia.repository;

import com.projeto.academia.model.Membro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MembroRepository extends JpaRepository<Membro, UUID> {

}