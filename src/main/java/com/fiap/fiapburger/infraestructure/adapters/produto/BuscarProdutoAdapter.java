package com.fiap.fiapburger.infraestructure.adapters.produto;

import com.fiap.fiapburger.infraestructure.persistence.repositories.ProdutoRepository;
import com.fiap.fiapburger.infraestructure.persistence.entities.ProdutoEntity;
import com.fiap.fiapburger.infraestructure.persistence.mapper.ProdutoEntityMapper;
import com.fiap.fiapburger.core.domain.entities.ProdutoDTO;
import com.fiap.fiapburger.core.ports.out.produto.BuscarProdutoOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BuscarProdutoAdapter implements BuscarProdutoOutputPort {

    private final ProdutoRepository produtoRepository;
    private final ProdutoEntityMapper produtoMapper;

    @Autowired
    public BuscarProdutoAdapter(ProdutoRepository produtoRepository, ProdutoEntityMapper produtoMapper) {
        this.produtoRepository = produtoRepository;
        this.produtoMapper = produtoMapper;
    }

    @Override
    public ProdutoDTO buscar(String id) {
        Optional<ProdutoEntity> produtoEntity = produtoRepository.findById(id);

        return produtoEntity.map(produtoMapper::toProdutoDTO).orElse(null);
    }
}