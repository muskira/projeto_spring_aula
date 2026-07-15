package br.com.senac.projeto_spring_aula.product;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name ="product")
@Getter
@Setter

public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private BigDecimal preco;
    @Column(nullable = false)
    private Long quantidadeEstoque;

    @Enumerated(EnumType.STRING)
    private ProductStatus status;



}
