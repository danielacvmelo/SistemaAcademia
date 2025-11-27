package com.projeto.academia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "agendamentos")
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "membro_id", nullable = false)
    private Membro membro;

    // Um agendamento pode ou não ter um instrutor específico
    @ManyToOne
    @JoinColumn(name = "instrutor_id")
    private Instrutor instrutor;

    @Column(nullable = false)
    private String tipo; // Ex: "Avaliação Física", "Aula Experimental"

    @Column(name = "data_hora", nullable = false)
    private LocalDateTime dataHora;

    @Column(length = 30)
    private String status; // Ex: "Agendado", "Concluído", "Cancelado"

    @Column(columnDefinition = "TEXT")
    private String observacoes;
}