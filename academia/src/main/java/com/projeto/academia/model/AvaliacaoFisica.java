package com.projeto.academia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal; // <--- Importante! O tipo exato.
import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "avaliacoes_fisicas")
public class AvaliacaoFisica {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "membro_id", nullable = false)
    private Membro membro;

    @ManyToOne
    @JoinColumn(name = "instrutor_id", nullable = false)
    private Instrutor instrutor;

    @Column(name = "data_avaliacao", nullable = false)
    private LocalDate dataAvaliacao;

    @Column
    private BigDecimal peso; // Mudou de Double para BigDecimal

    @Column
    private BigDecimal altura; // Mudou de Double para BigDecimal

    @Column(name = "percentual_gordura")
    private BigDecimal percentualGordura; // Mudou de Double para BigDecimal

    @Column(columnDefinition = "TEXT")
    private String observacoes;
}