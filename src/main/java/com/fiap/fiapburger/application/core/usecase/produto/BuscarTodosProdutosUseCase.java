package com.fiap.fiapburger.application.core.usecase.produto;

import com.fiap.fiapburger.adapter.in.controller.response.ProdutoResponse;
import com.fiap.fiapburger.application.ports.in.produto.BuscarTodosProdutosInputPort;
import com.fiap.fiapburger.application.ports.out.produto.BuscarTodosProdutosOutputPort;


import java.util.List;

public class BuscarTodosProdutosUseCase implements BuscarTodosProdutosInputPort {

    private final BuscarTodosProdutosOutputPort buscarTodosProdutosOutputPort;

    public BuscarTodosProdutosUseCase(BuscarTodosProdutosOutputPort buscarTodosProdutosOutputPort) {
        this.buscarTodosProdutosOutputPort = buscarTodosProdutosOutputPort;
    }


    @Override
    public List<ProdutoResponse> buscarTodos() {
        return buscarTodosProdutosOutputPort.buscarTodos();
    }

    @Override
    public List<ProdutoResponse> buscarTodosPorCategoria(String id) {
        return buscarTodosProdutosOutputPort.buscarTodosPorCategoria(id);
    }
}
