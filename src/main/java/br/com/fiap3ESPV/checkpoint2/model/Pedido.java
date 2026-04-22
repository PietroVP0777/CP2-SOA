package br.com.fiap3ESPV.checkpoint2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "pedidos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do cliente é obrigatório.")
    private String clienteNome;

    private LocalDate dataPedido;

    @PositiveOrZero(message = "O valor total do pedido não pode ser negativo.")
    private double valorTotal;

    @PrePersist
    public void preencherDataPedido() {
        this.dataPedido = LocalDate.now();
    }

    public void atualizarInformacoes(DadosAtualizarPedido dados){
        this.clienteNome = dados.clienteNome();

        this.valorTotal = dados.valorTotal();

    }

    public Pedido(DadosCriarPedido dados) {
        this.clienteNome = dados.clienteNome();
        this.valorTotal = dados.valorTotal();
    }
}