package br.com.fiap3ESPV.checkpoint2.controller;

import br.com.fiap3ESPV.checkpoint2.model.DadosAtualizarPedido;
import br.com.fiap3ESPV.checkpoint2.model.DadosCriarPedido;
import br.com.fiap3ESPV.checkpoint2.model.Pedido;
import br.com.fiap3ESPV.checkpoint2.service.PedidoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @GetMapping
    public List<Pedido> listarPedidos(){
        return service.listarPedidos();
    }

    @GetMapping("/{id}")
    public Pedido buscarPedido(@PathVariable Long id){
        return service.pedidoPorID(id);
    }

    @PostMapping
    @Transactional
    public void criarPedido(@RequestBody @Valid DadosCriarPedido dados){
        service.criarPedido(dados);
    }

    @PutMapping("/{id}")
    @Transactional
    public void atualizarPedido(@PathVariable Long id, @RequestBody @Valid DadosAtualizarPedido dados) {
        service.atualizarPedido(id, dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletarPedido(@PathVariable Long id){
        service.deletarPedido(id);
    }
}
