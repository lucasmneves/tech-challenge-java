package com.fiap.fiapburger.adapter.in.controller;

import com.fiap.fiapburger.adapter.in.controller.request.ProdutoRequest;
import com.fiap.fiapburger.adapter.in.controller.response.ProdutoResponse;
import com.fiap.fiapburger.application.ports.in.BuscarProdutoInputPort;
import com.fiap.fiapburger.application.ports.in.DeletarProdutoInputPort;
import com.fiap.fiapburger.application.ports.in.EditarProdutoInputPort;
import com.fiap.fiapburger.application.ports.in.SalvarProdutoInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final SalvarProdutoInputPort salvarProdutoInputPort;
    private final BuscarProdutoInputPort buscarProdutoInputPort;
    private final EditarProdutoInputPort editarProdutoInputPort;
    private final DeletarProdutoInputPort deletarProdutoInputPort;

    @Autowired
    public ProdutoController(SalvarProdutoInputPort salvarProdutoInputPort,
                             BuscarProdutoInputPort buscarProdutoInputPort,
                             EditarProdutoInputPort editarProdutoInputPort,
                             DeletarProdutoInputPort deletarProdutoInputPort) {
        this.salvarProdutoInputPort = salvarProdutoInputPort;
        this.buscarProdutoInputPort = buscarProdutoInputPort;
        this.editarProdutoInputPort = editarProdutoInputPort;
        this.deletarProdutoInputPort = deletarProdutoInputPort;
    }

    @PostMapping
    public ResponseEntity<ProdutoResponse> salvarProduto(@RequestBody ProdutoRequest produtoRequest) {
        ProdutoResponse produtoResponse = salvarProdutoInputPort.salvarProduto(produtoRequest);
        return ResponseEntity.ok(produtoResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponse> buscarProduto(@PathVariable Long id) {
        ProdutoResponse produtoResponse = buscarProdutoInputPort.buscarProduto(id);
        return ResponseEntity.ok(produtoResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponse> editarProduto(@PathVariable Long id, @RequestBody ProdutoRequest produtoRequest) {
        ProdutoResponse produtoResponse = editarProdutoInputPort.editarProduto(id, produtoRequest);
        return ResponseEntity.ok(produtoResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
        deletarProdutoInputPort.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }
}