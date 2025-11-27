package com.projeto.academia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "planos_membresia")
public class PlanoDeMembresia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome; // Ex: "Plano Mensal", "Plano Anual Fit"

    @Column(columnDefinition = "TEXT")
    private String descricao; // Ex: "Acesso a todas as áreas e aulas coletivas"

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal preco;

    @Column(name = "duracao_meses")
    private Integer duracaoMeses; // Ex: 1, 3, 6, 12

    @Column(nullable = false)
    private boolean ativo = true; // Define se o plano está disponível para novas contratações
}