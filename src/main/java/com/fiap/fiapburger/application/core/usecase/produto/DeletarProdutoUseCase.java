package com.fiap.fiapburger.application.core.usecase.produto;

import com.fiap.fiapburger.application.ports.in.produto.DeletarProdutoInputPort;
import com.fiap.fiapburger.application.ports.out.produto.DeletarProdutoOutputPort;

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