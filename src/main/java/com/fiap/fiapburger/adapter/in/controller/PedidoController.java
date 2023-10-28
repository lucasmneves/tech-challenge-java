package com.fiap.fiapburger.adapter.in.controller;

import com.fiap.fiapburger.adapter.in.controller.mapper.PedidoMapper;
import com.fiap.fiapburger.adapter.in.controller.request.EditarPedidoRequest;
import com.fiap.fiapburger.adapter.in.controller.request.SalvarPedidoRequest;
import com.fiap.fiapburger.application.core.domain.ItensPedidoDTO;
import com.fiap.fiapburger.application.ports.in.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private SalvarPedidoInputPort salvarPedidoInputPort;

    @Autowired
    private EditarPedidoInputPort editarPedidoInputPort;

    @Autowired
    private PedidoMapper pedidoMapper;

    @PostMapping
    public ResponseEntity<String> salvar(@Valid @RequestBody SalvarPedidoRequest salvarPedidoRequest){
        var pedido = pedidoMapper.toPedido(salvarPedidoRequest);
        salvarPedidoInputPort.salvar(pedido);
        return ResponseEntity.ok("Carrinho criado para o cliente " + salvarPedidoRequest.getCpf() + " com sucesso!");
    }

    @PatchMapping
    public ResponseEntity<String> editar(@Valid @RequestBody EditarPedidoRequest editarPedidoRequest){
        System.out.println("teste: " + editarPedidoRequest.getIdProduto().get(0));
        ItensPedidoDTO itensPedido = PedidoMapper.editarPedido(editarPedidoRequest);
        editarPedidoInputPort.editar(itensPedido);
        return ResponseEntity.ok("Carrinho editado com sucesso!");
    };

    @GetMapping
    public ResponseEntity<String> buscar(){
        return ResponseEntity.ok("Carrinho consulta com sucesso!");
    }

    @GetMapping("/lista")
    public ResponseEntity<String> listar(){
        return ResponseEntity.ok("Carrinho lista com sucesso!");
    }



    @DeleteMapping
    public ResponseEntity<String> deletar(){
        return ResponseEntity.ok("Carrinho deletado com sucesso!");
    };
}
