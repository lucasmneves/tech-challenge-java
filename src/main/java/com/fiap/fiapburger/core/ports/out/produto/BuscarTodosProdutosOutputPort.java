package com.fiap.fiapburger.core.ports.out.produto;

import com.fiap.fiapburger.infraestructure.api.responses.ProdutoResponse;

import java.util.List;

public interface BuscarTodosProdutosOutputPort {

    List<ProdutoResponse> buscarTodos();
    List<ProdutoResponse> buscarTodosPorCategoria(String id);
}
