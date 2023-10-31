package com.fiap.fiapburger.adapter.out.produto;

import com.fiap.fiapburger.adapter.out.repository.ProdutoRepository;
import com.fiap.fiapburger.adapter.out.repository.entity.ProdutoEntity;
import com.fiap.fiapburger.adapter.out.repository.mapper.ProdutoEntityMapper;
import com.fiap.fiapburger.application.core.domain.ProdutoDTO;

import com.fiap.fiapburger.application.ports.out.produto.SalvarProdutoOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SalvarProdutoAdapter implements SalvarProdutoOutputPort {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoEntityMapper produtoEntityMapper;

    @Override
    public void salvar(ProdutoDTO produto) {
        ProdutoEntity produtoEntity = produtoEntityMapper.toProdutoEntity(produto);
        ProdutoEntity savedEntity = produtoRepository.save(produtoEntity);
        //return produtoEntityMapper.toProdutoDTO(savedEntity);
    }
}