package br.com.senac.projeto_spring_aula.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductPostDto(
        @NotBlank(message = "O campo nome é obrigatório")
        String nome,
        @NotBlank(message = "O campo preço é obrigatório")
        @Positive
        BigDecimal preco,
        Long quantidadeEstoque
) {
}