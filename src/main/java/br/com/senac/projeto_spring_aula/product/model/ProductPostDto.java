package br.com.senac.projeto_spring_aula.product.model;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record ProductPostDto(
        @NotBlank(message = "O campo nome é obrigatório")
        String nome,
        @NotBlank(message = "O campo preço é obrigatório")
        BigDecimal preco,
        Long quantidadeEstoque
) {
}