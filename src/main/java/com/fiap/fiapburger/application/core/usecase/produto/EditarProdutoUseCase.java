package com.fiap.fiapburger.application.core.usecase.produto;

import com.fiap.fiapburger.application.core.domain.ProdutoDTO;


import com.fiap.fiapburger.application.ports.in.produto.EditarProdutoInputPort;
import com.fiap.fiapburger.application.ports.out.produto.EditarProdutoOutputPort;

public class EditarProdutoUseCase implements EditarProdutoInputPort {

    private final EditarProdutoOutputPort editarProdutoOutputPort;


    public EditarProdutoUseCase(EditarProdutoOutputPort editarProdutoOutputPort) {
        this.editarProdutoOutputPort = editarProdutoOutputPort;
    }

    @Override
    public ProdutoDTO editar(String id, ProdutoDTO produtoDTO) {
        return editarProdutoOutputPort.editar(id, produtoDTO);
    }
}