package com.fiap.fiapburger.adapter.out.produto;

import com.fiap.fiapburger.adapter.out.repository.ProdutoRepository;
import com.fiap.fiapburger.adapter.out.repository.entity.ProdutoEntity;
import com.fiap.fiapburger.adapter.out.repository.mapper.ProdutoEntityMapper;
import com.fiap.fiapburger.application.core.domain.ProdutoDTO;
import com.fiap.fiapburger.application.core.exception.ProdutoNaoEncontradoException;
import com.fiap.fiapburger.application.core.exception.ExceptionsMessageEnum;
import com.fiap.fiapburger.application.ports.out.produto.EditarProdutoOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EditarProdutoAdapter implements EditarProdutoOutputPort {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoEntityMapper produtoEntityMapper;

    @Override
    public ProdutoDTO editar(String id, ProdutoDTO produtoDTO) {
        ProdutoEntity produtoEntity = produtoRepository.findById(id)
                .orElseThrow(() -> new ProdutoNaoEncontradoException(ExceptionsMessageEnum.PRODUTO_NAO_ENCONTRADO.value()));

        produtoEntityMapper.updateEntityFromDTO(produtoDTO, produtoEntity);
        ProdutoEntity updatedEntity = produtoRepository.save(produtoEntity);

        return produtoEntityMapper.toProdutoDTO(updatedEntity);
    }
}