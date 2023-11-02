package com.fiap.fiapburger.adapter.out.produto;

import com.fiap.fiapburger.adapter.in.controller.mapper.ProdutoMapper;
import com.fiap.fiapburger.adapter.in.controller.response.ProdutoResponse;
import com.fiap.fiapburger.adapter.out.repository.ProdutoRepository;
import com.fiap.fiapburger.application.ports.out.produto.BuscarTodosProdutosOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BuscarTodosProdutosAdapter implements BuscarTodosProdutosOutputPort {

    @Autowired
    ProdutoRepository produtoRepository;
    @Autowired
    ProdutoMapper mapper;
    @Override
    public List<ProdutoResponse> buscarTodos() {
        return produtoRepository.findAllProdutosComCategoria();
    }

    public List<ProdutoResponse> buscarTodosPorCategoria(String id) {
        return produtoRepository.findAllProdutosPorCategoria(id);
    }
}
