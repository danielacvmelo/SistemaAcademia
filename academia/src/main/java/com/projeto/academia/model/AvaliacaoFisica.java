package com.projeto.academia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

<<<<<<< Updated upstream
=======
import java.math.BigDecimal;
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
    private Double peso;

    @Column
    private Double altura;

    @Column(name = "percentual_gordura")
    private Double percentualGordura;
=======
    private BigDecimal peso;

    @Column
    private BigDecimal altura;

    @Column(name = "percentual_gordura")
    private BigDecimal percentualGordura;
>>>>>>> Stashed changes

    @Column(columnDefinition = "TEXT")
    private String observacoes;
}