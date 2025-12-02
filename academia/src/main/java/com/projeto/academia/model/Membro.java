package com.projeto.academia.model;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@Table(name = "membros")
public class Membro {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", nullable = false, unique = true)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "plano_id")
    private PlanoDeMembresia plano;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "data_matricula", nullable = false)
    private LocalDate dataMatricula;

    @Column(length = 20)
    private String status;
}