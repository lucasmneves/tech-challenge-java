package com.fiap.fiapburger.infraestructure.adapters.produto;

import com.fiap.fiapburger.infraestructure.api.mappers.ProdutoMapper;
import com.fiap.fiapburger.infraestructure.api.responses.ProdutoResponse;
import com.fiap.fiapburger.infraestructure.persistence.repositories.ProdutoRepository;
import com.fiap.fiapburger.core.ports.out.produto.BuscarTodosProdutosOutputPort;
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
