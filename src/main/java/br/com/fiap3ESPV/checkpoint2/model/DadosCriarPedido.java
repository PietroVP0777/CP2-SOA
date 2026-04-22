package br.com.fiap3ESPV.checkpoint2.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

public record DadosCriarPedido(
        @NotBlank
        String clienteNome,

        @PositiveOrZero
        Double valorTotal
) {
}
