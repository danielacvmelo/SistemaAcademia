package com.projeto.academia.repository;

import com.projeto.academia.model.Instrutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface InstrutorRepository extends JpaRepository<Instrutor, UUID> {
    boolean existsByCref(String cref);
}