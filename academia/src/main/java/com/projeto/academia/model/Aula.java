package com.projeto.academia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "aulas")
public class Aula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome; // Ex: "Spinning", "Yoga", "Zumba"

    @Column
    private String diaDaSemana; // Ex: "Segunda-feira", "Terça-feira"

    @Column
    private LocalTime horario;

    @Column(name = "duracao_minutos")
    private Integer duracaoMinutos;

    @ManyToOne
    @JoinColumn(name = "instrutor_id")
    private Instrutor instrutor; // Relacionamento com a entidade Instrutor
}