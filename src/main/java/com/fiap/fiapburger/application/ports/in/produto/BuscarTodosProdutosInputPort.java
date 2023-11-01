package com.fiap.fiapburger.application.ports.in.produto;

import com.fiap.fiapburger.adapter.in.controller.response.ProdutoResponse;

import java.util.List;

public interface BuscarTodosProdutosInputPort {
        List<ProdutoResponse> buscarTodos();
}
