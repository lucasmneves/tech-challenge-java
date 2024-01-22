package com.fiap.fiapburger.adapter.in.controller;

import com.fiap.fiapburger.adapter.in.controller.mapper.PedidoMapper;
import com.fiap.fiapburger.adapter.in.controller.request.*;
import com.fiap.fiapburger.adapter.in.controller.response.PedidoResponse;
import com.fiap.fiapburger.adapter.in.controller.response.SalvarPedidoResponse;
import com.fiap.fiapburger.core.domain.entities.ItensPedidoDTO;
import com.fiap.fiapburger.core.domain.entities.PedidoDTO;
import com.fiap.fiapburger.core.ports.in.pedido.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    private ListarPedidosInputPort listarPedidosInputPort;

    @PostMapping
    @ResponseBody
    public ResponseEntity<SalvarPedidoResponse> salvar(@Valid @RequestBody SalvarPedidoRequest salvarPedidoRequest){
        var response = salvarPedidoInputPort.salvar(salvarPedidoRequest);
        return ResponseEntity.ok(response);
    }

    @PatchMapping
    public ResponseEntity<String> adicionarItensPedido(@Valid @RequestBody AdicionarItensPedidoRequest adicionarItensPedidoRequest){
        editarPedidoInputPort.editar(adicionarItensPedidoRequest);
        return ResponseEntity.ok("Pedido atualizado com sucesso!");
    };

    @PostMapping("/confirmar")
    public ResponseEntity<String> confirmarPedido(@Valid @RequestBody ConfirmarPedidoRequest confirmarPedidoRequest){
        confirmarPedidoInputPort.confirmar(confirmarPedidoRequest);
        return ResponseEntity.ok("Pedido confirmado com sucesso!");
    };

    @PostMapping("/avaliar")
    public ResponseEntity<String> avaliarPedido(@Valid @RequestBody AvaliarPedidoRequest avaliarPedidoRequest){
        avaliarPedidoInputPort.avaliar(avaliarPedidoRequest);
        return ResponseEntity.ok("Pedido avaliado com sucesso!");
    };

    @DeleteMapping()
    public ResponseEntity<String> deletar(@Valid @RequestBody RemoverItensPedidoRequest removerItensPedidoRequest){
        deletarPedidoInputPort.deletar(removerItensPedidoRequest);
        return ResponseEntity.ok("Item do pedido deletado com sucesso!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponse> buscar(@PathVariable String idPedido){
        var pedido = buscarPedidoInputPort.buscaPedido(idPedido);
        return ResponseEntity.ok(pedido);
    }

    @GetMapping()
    public ResponseEntity<List<PedidoResponse>> listaPedidos(){
        var pedidos = listarPedidosInputPort.listaPedidos();
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/listar/{id_status}")
    public ResponseEntity<List<PedidoResponse>> listaPedidosPorStatus(@PathVariable String id_status){
        var pedidos = listarPedidosInputPort.listaPedidosPorStatus(id_status);
        return ResponseEntity.ok(pedidos);
    }

    @PatchMapping("/atualizar-status")
    public ResponseEntity<String> atualizarStatusPedido(@Valid @RequestBody AtualizarStatusPedidoRequest atualizarStatusPedidoRequest){
        editarPedidoInputPort.atualizarStatusPedido(PedidoMapper.atualizarStatusPedido(atualizarStatusPedidoRequest));
        return ResponseEntity.ok("Status do pedido atualizado com sucesso!");
    };
}
