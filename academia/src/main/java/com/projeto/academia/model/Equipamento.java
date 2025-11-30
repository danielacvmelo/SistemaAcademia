package com.projeto.academia.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Builder
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "equipamentos")
public class Equipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(name = "grupo_muscular", length = 50)
    private String grupoMuscular;

    @Column(name = "data_aquisicao")
    private LocalDate dataAquisicao;

    @Column(name = "ultima_manutencao")
    private LocalDate ultimaManutencao;

    @Column(length = 30)
    private String status;
}