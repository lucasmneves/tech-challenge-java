package com.fiap.fiapburger.application.core.usecase;

import com.fiap.fiapburger.application.ports.in.DeletarProdutoInputPort;
import com.fiap.fiapburger.application.ports.out.DeletarProdutoOutputPort;

public class DeletarProdutoUseCase implements DeletarProdutoInputPort {

    private final DeletarProdutoOutputPort outputPort;

    public DeletarProdutoUseCase(DeletarProdutoOutputPort outputPort) {
        this.outputPort = outputPort;
    }

    @Override
    public void deletar(Long id) {
        outputPort.deletar(id);
    }
}