package com.fiap.fiapburger.application.ports.out.produto;

import com.fiap.fiapburger.adapter.in.controller.response.ProdutoResponse;

import java.util.List;

public interface BuscarTodosProdutosOutputPort {

    List<ProdutoResponse> buscarTodos();
    List<ProdutoResponse> buscarTodosPorCategoria(String id);
}
