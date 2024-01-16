package com.fiap.fiapburger.core.usecase.produto;

import com.fiap.fiapburger.core.domain.entities.ProdutoDTO;


import com.fiap.fiapburger.core.ports.in.produto.EditarProdutoInputPort;
import com.fiap.fiapburger.core.ports.out.produto.EditarProdutoOutputPort;

public class EditarProdutoUseCase implements EditarProdutoInputPort {

    private final EditarProdutoOutputPort editarProdutoOutputPort;


    public EditarProdutoUseCase(EditarProdutoOutputPort editarProdutoOutputPort) {
        this.editarProdutoOutputPort = editarProdutoOutputPort;
    }

    @Override
    public ProdutoDTO editar(String id, ProdutoDTO produtoDTO) {
        produtoDTO.setId(id);
        return editarProdutoOutputPort.editar(id, produtoDTO);
    }
}