package com.fiap.fiapburger.adapter.in.controller;

import com.fiap.fiapburger.adapter.in.controller.mapper.PedidoMapper;
import com.fiap.fiapburger.adapter.in.controller.request.AdicionarItensPedidoRequest;
import com.fiap.fiapburger.adapter.in.controller.request.RemoverItensPedidoRequest;
import com.fiap.fiapburger.adapter.in.controller.request.SalvarPedidoRequest;
import com.fiap.fiapburger.adapter.in.controller.response.PedidoResponse;
import com.fiap.fiapburger.adapter.out.repository.entity.PedidoEntity;
import com.fiap.fiapburger.application.core.domain.ItensPedidoDTO;
import com.fiap.fiapburger.application.core.domain.PedidoDTO;
import com.fiap.fiapburger.application.ports.in.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private SalvarPedidoInputPort salvarPedidoInputPort;

    @Autowired
    private EditarPedidoInputPort editarPedidoInputPort;

    @Autowired
    private BuscarPedidoInputPort buscarPedidoInputPort;

    @Autowired
    private DeletarPedidoInputPort deletarPedidoInputPort;

    @Autowired
    private PedidoMapper pedidoMapper;

    @PostMapping
    public ResponseEntity<String> salvar(@Valid @RequestBody SalvarPedidoRequest salvarPedidoRequest){
        var pedido = pedidoMapper.toPedido(salvarPedidoRequest);
        salvarPedidoInputPort.salvar(pedido);
        return ResponseEntity.ok("Carrinho criado para o cliente " + salvarPedidoRequest.getCpf() + " com sucesso!");
    }

    @PatchMapping
    public ResponseEntity<String> adicionarItensPedido(@Valid @RequestBody AdicionarItensPedidoRequest adicionarItensPedidoRequest){
        ItensPedidoDTO itensPedido = PedidoMapper.adicionarItensPedido(adicionarItensPedidoRequest);
        PedidoDTO pedido = PedidoMapper.editar(adicionarItensPedidoRequest);
        editarPedidoInputPort.adicionarItens(itensPedido);
        editarPedidoInputPort.editar(pedido, itensPedido);
        return ResponseEntity.ok("Carrinho atualizado com sucesso!");
    };

    @GetMapping()
    public ResponseEntity<PedidoResponse> buscar(@RequestParam String id){
        var pedido = buscarPedidoInputPort.buscaPedido(id);
        return ResponseEntity.ok(pedido);
    }

    @DeleteMapping()
    public ResponseEntity<String> deletar(@Valid @RequestBody RemoverItensPedidoRequest removerItensPedidoRequest){
        ItensPedidoDTO itensPedido = PedidoMapper.removerItensPedido(removerItensPedidoRequest);
        deletarPedidoInputPort.removerItens(removerItensPedidoRequest.getIdProduto(), removerItensPedidoRequest.getIdPedido());
        deletarPedidoInputPort.deletar(removerItensPedidoRequest.getIdProduto(), removerItensPedidoRequest.getIdPedido());
        return ResponseEntity.noContent().build();
    }

}
