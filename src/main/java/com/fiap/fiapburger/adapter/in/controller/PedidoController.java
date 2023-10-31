package com.fiap.fiapburger.adapter.in.controller;

import com.fiap.fiapburger.adapter.in.controller.mapper.PedidoMapper;
import com.fiap.fiapburger.adapter.in.controller.request.*;
import com.fiap.fiapburger.adapter.in.controller.response.PedidoResponse;
import com.fiap.fiapburger.adapter.in.controller.response.SalvarPedidoResponse;
import com.fiap.fiapburger.application.core.domain.ItensPedidoDTO;
import com.fiap.fiapburger.application.core.domain.PedidoDTO;
import com.fiap.fiapburger.application.ports.in.pedido.*;
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
    private BuscarPedidoInputPort buscarPedidoInputPort;

    @Autowired
    private DeletarPedidoInputPort deletarPedidoInputPort;

    @Autowired
    private ConfirmarPedidoInputPort confirmarPedidoInputPort;

    @Autowired
    private AvaliarPedidoInputPort avaliarPedidoInputPort;

    @Autowired
    private PedidoMapper pedidoMapper;

    @PostMapping
    @ResponseBody
    public ResponseEntity<SalvarPedidoResponse> salvar(@Valid @RequestBody SalvarPedidoRequest salvarPedidoRequest){
        var pedido = pedidoMapper.toPedido(salvarPedidoRequest);
        salvarPedidoInputPort.salvar(pedido);
        SalvarPedidoResponse response = new SalvarPedidoResponse();
        response.setId(pedido.getId());
        return ResponseEntity.ok(response);
    }

    @PatchMapping
    public ResponseEntity<String> adicionarItensPedido(@Valid @RequestBody AdicionarItensPedidoRequest adicionarItensPedidoRequest){
        ItensPedidoDTO itensPedido = PedidoMapper.adicionarItensPedido(adicionarItensPedidoRequest);
        PedidoDTO pedido = PedidoMapper.editar(adicionarItensPedidoRequest);
        editarPedidoInputPort.adicionarItens(itensPedido);
        editarPedidoInputPort.editar(pedido, itensPedido);
        return ResponseEntity.ok("Pedido atualizado com sucesso!");
    };

    @PostMapping("/confirmar")
    public ResponseEntity<String> confirmarPedido(@Valid @RequestBody ConfirmarPedidoRequest confirmarPedidoRequest){
        PedidoDTO pedido = PedidoMapper.confirmarPedido(confirmarPedidoRequest);
        confirmarPedidoInputPort.confirmar(pedido);
        return ResponseEntity.ok("Pedido confirmado com sucesso!");
    };

    @PostMapping("/avaliar")
    public ResponseEntity<String> avaliarPedido(@Valid @RequestBody AvaliarPedidoRequest avaliarPedidoRequest){
        PedidoDTO pedido = PedidoMapper.avaliarPedido(avaliarPedidoRequest);
        avaliarPedidoInputPort.avaliar(pedido);
        return ResponseEntity.ok("Pedido avaliado com sucesso!");
    };

    @DeleteMapping()
    public ResponseEntity<String> deletar(@Valid @RequestBody RemoverItensPedidoRequest removerItensPedidoRequest){
        ItensPedidoDTO itensPedido = PedidoMapper.removerItensPedido(removerItensPedidoRequest);
        deletarPedidoInputPort.removerItens(removerItensPedidoRequest.getIdProduto(), removerItensPedidoRequest.getIdPedido());
        deletarPedidoInputPort.deletar(removerItensPedidoRequest.getIdProduto(), removerItensPedidoRequest.getIdPedido());
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponse> buscar(@PathVariable String id){
        PedidoDTO pedidoDTO = new PedidoDTO();
        pedidoDTO.setId(id);
        var pedido = buscarPedidoInputPort.buscaPedido(pedidoDTO);
        return ResponseEntity.ok(pedido);
    }

}
