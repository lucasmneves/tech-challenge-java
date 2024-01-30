package com.fiap.fiapburger.core.usecase.produto;

import com.fiap.fiapburger.infraestructure.api.mappers.ProdutoMapper;
import com.fiap.fiapburger.infraestructure.api.requests.ProdutoRequest;
import com.fiap.fiapburger.core.domain.entities.ProdutoDTO;


import com.fiap.fiapburger.core.ports.in.produto.EditarProdutoInputPort;
import com.fiap.fiapburger.core.ports.out.produto.EditarProdutoOutputPort;

public class EditarProdutoUseCase implements EditarProdutoInputPort {

    private final EditarProdutoOutputPort editarProdutoOutputPort;
    private final ProdutoMapper produtoMapper;

    public EditarProdutoUseCase(EditarProdutoOutputPort editarProdutoOutputPort, ProdutoMapper produtoMapper) {
        this.editarProdutoOutputPort = editarProdutoOutputPort;
        this.produtoMapper = produtoMapper;
    }

    @Override
    public ProdutoDTO editar(String id, ProdutoRequest produtoRequest) {
        ProdutoDTO produtoDTO = produtoMapper.toProdutoDTO(produtoRequest);
        produtoDTO.setId(id);
        return editarProdutoOutputPort.editar(id, produtoDTO);
    }
}