package com.fiap.fiapburger.core.ports.in.produto;

import com.fiap.fiapburger.infraestructure.api.responses.ProdutoResponse;

import java.util.List;

public interface BuscarTodosProdutosInputPort {
        List<ProdutoResponse> buscarTodos();
        List<ProdutoResponse> buscarTodosPorCategoria(String id);
}
