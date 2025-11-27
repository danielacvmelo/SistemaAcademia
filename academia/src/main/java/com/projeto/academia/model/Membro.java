package com.projeto.academia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "membros")
public class Membro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "data_matricula", nullable = false)
    private LocalDate dataMatricula;

    @Column(length = 50)
    private String plano; // Ex: "Mensal", "Anual", "Familiar"

    @Column(length = 20)
    private String status; // Ex: "Ativo", "Inativo", "Pendente"
}