package com.fiap.fiapburger.adapter.in.controller;

import com.fiap.fiapburger.adapter.in.controller.request.ProdutoRequest;
import com.fiap.fiapburger.adapter.in.controller.response.ProdutoResponse;
import com.fiap.fiapburger.adapter.in.controller.mapper.ProdutoMapper;
import com.fiap.fiapburger.application.core.domain.ProdutoDTO;


import com.fiap.fiapburger.application.ports.in.produto.BuscarProdutoInputPort;
import com.fiap.fiapburger.application.ports.in.produto.DeletarProdutoInputPort;
import com.fiap.fiapburger.application.ports.in.produto.EditarProdutoInputPort;
import com.fiap.fiapburger.application.ports.in.produto.SalvarProdutoInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final SalvarProdutoInputPort salvarProdutoInputPort;
    private final BuscarProdutoInputPort buscarProdutoInputPort;
    private final EditarProdutoInputPort editarProdutoInputPort;
    private final DeletarProdutoInputPort deletarProdutoInputPort;

    private final ProdutoMapper produtoMapper;


    @Autowired
    public ProdutoController(SalvarProdutoInputPort salvarProdutoInputPort,
                             BuscarProdutoInputPort buscarProdutoInputPort,
                             EditarProdutoInputPort editarProdutoInputPort,
                             DeletarProdutoInputPort deletarProdutoInputPort,
                             ProdutoMapper produtoMapper) {
        this.salvarProdutoInputPort = salvarProdutoInputPort;
        this.buscarProdutoInputPort = buscarProdutoInputPort;
        this.editarProdutoInputPort = editarProdutoInputPort;
        this.deletarProdutoInputPort = deletarProdutoInputPort;
        this.produtoMapper = produtoMapper;
    }

    @PostMapping
    public ResponseEntity<ProdutoResponse> salvarProduto(@RequestBody ProdutoRequest produtoRequest, UriComponentsBuilder uriComponentsBuilder){
        ProdutoDTO produtoDTO = produtoMapper.toProdutoDTO(produtoRequest);
        salvarProdutoInputPort.salvar(produtoDTO);
        return ResponseEntity.created(uriComponentsBuilder.path("/produtos/{id}").buildAndExpand(produtoDTO.getId()).toUri()).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponse> buscarProduto(@PathVariable String id) {
        ProdutoDTO produtoDTO = buscarProdutoInputPort.buscar(id);
        ProdutoResponse produtoResponse = produtoMapper.toProdutoResponse(produtoDTO);
        return ResponseEntity.ok(produtoResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponse> editarProduto(@PathVariable String id, @RequestBody ProdutoRequest produtoRequest) {
        ProdutoDTO produtoDTO = produtoMapper.toProdutoDTO(produtoRequest);
        ProdutoDTO updatedProdutoDTO = editarProdutoInputPort.editar(id, produtoDTO);
        ProdutoResponse produtoResponse = produtoMapper.toProdutoResponse(updatedProdutoDTO);
        return ResponseEntity.ok(produtoResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable String id) {
        deletarProdutoInputPort.deletar(id);
        return ResponseEntity.noContent().build();
    }
}