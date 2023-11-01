package com.fiap.fiapburger.application.core.usecase.produto;

import com.fiap.fiapburger.application.core.domain.ProdutoDTO;
import com.fiap.fiapburger.application.ports.in.produto.EditarProdutoInputPort;
import com.fiap.fiapburger.application.ports.out.produto.EditarProdutoOutputPort;

public class EditarProdutoUseCase implements EditarProdutoInputPort {

    private final EditarProdutoOutputPort outputPort;

    public EditarProdutoUseCase(EditarProdutoOutputPort outputPort) {
        this.outputPort = outputPort;
    }

    @Override
    public ProdutoDTO editar(ProdutoDTO produto) {
        return outputPort.editar(produto);
    }
}