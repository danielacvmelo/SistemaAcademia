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
@Table(name = "avaliacoes_fisicas")
public class AvaliacaoFisica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "membro_id", nullable = false)
    private Membro membro;

    @ManyToOne
    @JoinColumn(name = "instrutor_id", nullable = false)
    private Instrutor instrutor;

    @Column(name = "data_avaliacao", nullable = false)
    private LocalDate dataAvaliacao;

    @Column
    private Double peso; // em kg

    @Column
    private Double altura; // em cm

    @Column(name = "percentual_gordura")
    private Double percentualGordura;

    @Column(columnDefinition = "TEXT")
    private String observacoes; // Notas do instrutor
}