package com.fiap.fiapburger.application.core.usecase;

import com.fiap.fiapburger.application.core.domain.ProdutoDTO;
import com.fiap.fiapburger.application.ports.in.EditarProdutoInputPort;
import com.fiap.fiapburger.application.ports.out.EditarProdutoOutputPort;

public class EditarProdutoUseCase implements EditarProdutoInputPort {

    private final EditarProdutoOutputPort outputPort;

    public EditarProdutoUseCase(EditarProdutoOutputPort outputPort) {
        this.outputPort = outputPort;
    }

    @Override
    public void editar(ProdutoDTO produto) {
        outputPort.editar(produto);
    }
}