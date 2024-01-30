package com.fiap.fiapburger.infraestructure.adapters.produto;

import com.fiap.fiapburger.infraestructure.persistence.repositories.ProdutoRepository;

import com.fiap.fiapburger.core.domain.exception.ExceptionsMessageEnum;
import com.fiap.fiapburger.core.domain.exception.ProdutoNaoEncontradoException;
import com.fiap.fiapburger.core.ports.out.produto.DeletarProdutoOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeletarProdutoAdapter implements DeletarProdutoOutputPort {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public void deletar(String id) {
        var produto  = produtoRepository.findById(id).orElseThrow(()-> new ProdutoNaoEncontradoException(ExceptionsMessageEnum.PRODUTO_NAO_ENCONTRADO.value()));
        produtoRepository.delete(produto);

    }
}