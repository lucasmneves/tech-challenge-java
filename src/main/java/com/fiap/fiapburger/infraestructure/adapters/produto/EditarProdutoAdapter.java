package com.fiap.fiapburger.infraestructure.adapters.produto;

import com.fiap.fiapburger.infraestructure.persistence.repositories.ProdutoRepository;
import com.fiap.fiapburger.infraestructure.persistence.entities.ProdutoEntity;
import com.fiap.fiapburger.infraestructure.persistence.mapper.ProdutoEntityMapper;
import com.fiap.fiapburger.core.domain.entities.ProdutoDTO;
import com.fiap.fiapburger.core.domain.exception.ProdutoNaoEncontradoException;
import com.fiap.fiapburger.core.domain.exception.ExceptionsMessageEnum;
import com.fiap.fiapburger.core.ports.out.produto.EditarProdutoOutputPort;
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