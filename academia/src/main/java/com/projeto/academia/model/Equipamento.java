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
@Table(name = "equipamentos")
public class Equipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome; // Ex: "Esteira Ergométrica", "Leg Press 45º"

    @Column(name = "grupo_muscular", length = 50)
    private String grupoMuscular; // Ex: "Cardio", "Pernas", "Superiores"

    @Column(name = "data_aquisicao")
    private LocalDate dataAquisicao;

    @Column(name = "ultima_manutencao")
    private LocalDate ultimaManutencao;

    @Column(length = 30)
    private String status; // Ex: "Operacional", "Em Manutenção"
}