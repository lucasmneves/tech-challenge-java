package com.fiap.fiapburger.infraestructure.api.controllers;

import com.fiap.fiapburger.infraestructure.api.requests.ProdutoRequest;
import com.fiap.fiapburger.infraestructure.api.responses.ProdutoResponse;
import com.fiap.fiapburger.infraestructure.api.mappers.ProdutoMapper;
import com.fiap.fiapburger.core.domain.entities.ProdutoDTO;


import com.fiap.fiapburger.core.ports.in.produto.BuscarTodosProdutosInputPort;
import com.fiap.fiapburger.core.ports.in.produto.BuscarProdutoInputPort;
import com.fiap.fiapburger.core.ports.in.produto.DeletarProdutoInputPort;
import com.fiap.fiapburger.core.ports.in.produto.EditarProdutoInputPort;
import com.fiap.fiapburger.core.ports.in.produto.SalvarProdutoInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;


@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final SalvarProdutoInputPort salvarProdutoInputPort;
    private final BuscarProdutoInputPort buscarProdutoInputPort;
    private final BuscarTodosProdutosInputPort buscarTodos;
    private final EditarProdutoInputPort editarProdutoInputPort;
    private final DeletarProdutoInputPort deletarProdutoInputPort;
    private final ProdutoMapper produtoMapper;


    @Autowired
    public ProdutoController(SalvarProdutoInputPort salvarProdutoInputPort,
                             BuscarProdutoInputPort buscarProdutoInputPort,
                             BuscarTodosProdutosInputPort buscarTodos, EditarProdutoInputPort editarProdutoInputPort,
                             DeletarProdutoInputPort deletarProdutoInputPort,
                             ProdutoMapper produtoMapper) {
        this.salvarProdutoInputPort = salvarProdutoInputPort;
        this.buscarProdutoInputPort = buscarProdutoInputPort;
        this.buscarTodos = buscarTodos;
        this.editarProdutoInputPort = editarProdutoInputPort;
        this.deletarProdutoInputPort = deletarProdutoInputPort;
        this.produtoMapper = produtoMapper;
    }

    @PostMapping
    public ResponseEntity<ProdutoResponse> salvarProduto(@RequestBody ProdutoRequest produtoRequest, UriComponentsBuilder uriComponentsBuilder){
        var produtoSalvo = salvarProdutoInputPort.salvar(produtoRequest);
        return ResponseEntity.created(uriComponentsBuilder.path("/produtos/{id}").buildAndExpand(produtoSalvo.getId()).toUri()).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponse> buscarProduto(@PathVariable String id) {
        ProdutoDTO produtoDTO = buscarProdutoInputPort.buscar(id);
        ProdutoResponse produtoResponse = produtoMapper.toProdutoResponse(produtoDTO);
        return ResponseEntity.ok(produtoResponse);
    }

    @GetMapping()
    public ResponseEntity<List<ProdutoResponse>> buscarProdutos() {
        return ResponseEntity.ok(buscarTodos.buscarTodos());
    }

    @GetMapping("/categoria/{id}")
    public ResponseEntity<List<ProdutoResponse>> buscarProdutosPorCategoria(@PathVariable String id) {
        return ResponseEntity.ok(buscarTodos.buscarTodosPorCategoria(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponse> editarProduto(@PathVariable String id, @RequestBody ProdutoRequest produtoRequest) {
        ProdutoDTO updatedProdutoDTO = editarProdutoInputPort.editar(id, produtoRequest);
        ProdutoResponse produtoResponse = produtoMapper.toProdutoResponse(updatedProdutoDTO);
        return ResponseEntity.ok(produtoResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable String id) {
        deletarProdutoInputPort.deletar(id);
        return ResponseEntity.noContent().build();
    }

}