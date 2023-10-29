package com.fiap.fiapburger.adapter.out;

import com.fiap.fiapburger.adapter.out.repository.ProdutoRepository;
import com.fiap.fiapburger.adapter.out.repository.entity.ProdutoEntity;
import com.fiap.fiapburger.adapter.out.repository.mapper.ProdutoEntityMapper;
import com.fiap.fiapburger.application.core.domain.ProdutoDTO;
import com.fiap.fiapburger.application.ports.out.SalvarProdutoOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SalvarProdutoAdapter implements SalvarProdutoOutputPort {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoEntityMapper produtoEntityMapper;

    @Override
    public ProdutoDTO salvar(ProdutoDTO produto) {
        ProdutoEntity produtoEntity = produtoEntityMapper.toProdutoEntity(produto);
        ProdutoEntity savedEntity = produtoRepository.save(produtoEntity);
        return produtoEntityMapper.toProdutoDTO(savedEntity);
    }
}