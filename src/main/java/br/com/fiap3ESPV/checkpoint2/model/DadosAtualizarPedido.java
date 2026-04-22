package br.com.fiap3ESPV.checkpoint2.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDate;

public record DadosAtualizarPedido(
        @NotBlank
        String clienteNome,

        @PositiveOrZero
        double valorTotal

) {

}
