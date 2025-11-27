package com.projeto.academia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "aulas")
public class Aula {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(name = "dia_da_semana")
    private String diaDaSemana;

    @Column
    private LocalTime horario;

    @Column(name = "duracao_minutos")
    private Integer duracaoMinutos;

    @ManyToOne
    @JoinColumn(name = "instrutor_id")
    private Instrutor instrutor;
}