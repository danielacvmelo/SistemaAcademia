package com.projeto.academia.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
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

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "data_avaliacao", nullable = false)
    private LocalDate dataAvaliacao;

    @Column

    private BigDecimal peso;

    @Column
    private BigDecimal altura;

    @Column(name = "percentual_gordura")

    private BigDecimal percentualGordura;

    @Column(columnDefinition = "TEXT")
    private String observacoes;
}