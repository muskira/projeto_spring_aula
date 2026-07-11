package br.com.senac.projeto_spring_aula.product;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record productPostDto(
        @NotBlank(message = "O campo nome é obrigatório")
        String nome,
        @NotBlank(message = "O campo autor é obrigatório")
        BigDecimal preco,
        Integer quantidadeEstoque
) {
}