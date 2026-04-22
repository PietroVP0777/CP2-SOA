package br.com.fiap3ESPV.checkpoint2.service;

import br.com.fiap3ESPV.checkpoint2.model.DadosAtualizarPedido;
import br.com.fiap3ESPV.checkpoint2.model.DadosCriarPedido;
import br.com.fiap3ESPV.checkpoint2.model.Pedido;
import br.com.fiap3ESPV.checkpoint2.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PedidoService {
    @Autowired
    PedidoRepository repository;

    public List<Pedido> listarPedidos(){
        return repository.findAll().stream().toList();
    }

    public Pedido pedidoPorID(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }

    public void criarPedido(DadosCriarPedido dados){
        Pedido pedido = new Pedido(dados);
        repository.save(pedido);
    }

    public void atualizarPedido(Long id, DadosAtualizarPedido dados){
        Pedido pedido = repository.getReferenceById(id);
        pedido.atualizarInformacoes(dados);
        repository.save(pedido);
    }

    public void deletarPedido(Long id){
        repository.deleteById(id);
    }
}
