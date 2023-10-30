package com.fiap.fiapburger.adapter.in.controller;

import com.fiap.fiapburger.adapter.in.controller.mapper.PedidoMapper;
import com.fiap.fiapburger.adapter.in.controller.request.AdicionarItensPedidoRequest;
import com.fiap.fiapburger.adapter.in.controller.request.RemoverItensPedidoRequest;
import com.fiap.fiapburger.adapter.in.controller.request.SalvarPedidoRequest;
import com.fiap.fiapburger.adapter.in.controller.response.PedidoResponse;
import com.fiap.fiapburger.application.core.domain.ItensPedidoDTO;
import com.fiap.fiapburger.application.core.domain.PedidoDTO;
import com.fiap.fiapburger.application.ports.in.pedido.BuscarPedidoInputPort;
import com.fiap.fiapburger.application.ports.in.pedido.DeletarPedidoInputPort;
import com.fiap.fiapburger.application.ports.in.pedido.EditarPedidoInputPort;
import com.fiap.fiapburger.application.ports.in.pedido.SalvarPedidoInputPort;
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
    public ResponseEntity<String> salvar(@Valid @RequestBody SalvarPedidoRequest salvarPedidoRequest,  UriComponentsBuilder uriComponentsBuilder){
        var pedido = pedidoMapper.toPedido(salvarPedidoRequest);
        salvarPedidoInputPort.salvar(pedido);
        return ResponseEntity.created(uriComponentsBuilder.path("/pedido/{id}").buildAndExpand(pedido.getId()).toUri()).build();
    }

    @PatchMapping
    public ResponseEntity<String> adicionarItensPedido(@Valid @RequestBody AdicionarItensPedidoRequest adicionarItensPedidoRequest){
        ItensPedidoDTO itensPedido = PedidoMapper.adicionarItensPedido(adicionarItensPedidoRequest);
        PedidoDTO pedido = PedidoMapper.editar(adicionarItensPedidoRequest);
        editarPedidoInputPort.adicionarItens(itensPedido);
        editarPedidoInputPort.editar(pedido, itensPedido);
        return ResponseEntity.ok("Carrinho atualizado com sucesso!");
    };

    @DeleteMapping()
    public ResponseEntity<String> deletar(@Valid @RequestBody RemoverItensPedidoRequest removerItensPedidoRequest){
        ItensPedidoDTO itensPedido = PedidoMapper.removerItensPedido(removerItensPedidoRequest);
        deletarPedidoInputPort.removerItens(removerItensPedidoRequest.getIdProduto(), removerItensPedidoRequest.getIdPedido());
        deletarPedidoInputPort.deletar(removerItensPedidoRequest.getIdProduto(), removerItensPedidoRequest.getIdPedido());
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponse> buscar(@PathVariable String id, UriComponentsBuilder uriComponentsBuilder){
        var pedido = buscarPedidoInputPort.buscaPedido(id);
        return ResponseEntity.ok(pedido);
    }

}
