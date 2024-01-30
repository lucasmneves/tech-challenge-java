package com.fiap.fiapburger.core.usecase.produto;

import com.fiap.fiapburger.infraestructure.api.responses.ProdutoResponse;
import com.fiap.fiapburger.core.ports.in.produto.BuscarTodosProdutosInputPort;
import com.fiap.fiapburger.core.ports.out.produto.BuscarTodosProdutosOutputPort;


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
