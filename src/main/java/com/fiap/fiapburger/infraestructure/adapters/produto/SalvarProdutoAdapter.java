package com.fiap.fiapburger.infraestructure.adapters.produto;

import com.fiap.fiapburger.infraestructure.persistence.repositories.ProdutoRepository;
import com.fiap.fiapburger.infraestructure.persistence.entities.ProdutoEntity;
import com.fiap.fiapburger.infraestructure.persistence.mapper.ProdutoEntityMapper;
import com.fiap.fiapburger.core.domain.entities.ProdutoDTO;

import com.fiap.fiapburger.core.ports.out.produto.SalvarProdutoOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SalvarProdutoAdapter implements SalvarProdutoOutputPort {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoEntityMapper produtoEntityMapper;

    @Override
    public ProdutoEntity salvar(ProdutoDTO produto) {
        ProdutoEntity produtoEntity = produtoEntityMapper.toProdutoEntity(produto);
        ProdutoEntity savedEntity = produtoRepository.save(produtoEntity);
        return savedEntity;
    }
}