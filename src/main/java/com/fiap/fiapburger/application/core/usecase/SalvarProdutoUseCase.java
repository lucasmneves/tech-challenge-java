package com.fiap.fiapburger.application.core.usecase;

import com.fiap.fiapburger.application.core.domain.ProdutoDTO;
import com.fiap.fiapburger.application.ports.in.SalvarProdutoInputPort;
import com.fiap.fiapburger.application.ports.out.SalvarProdutoOutputPort;

public class SalvarProdutoUseCase implements SalvarProdutoInputPort {

    private final SalvarProdutoOutputPort outputPort;

    public SalvarProdutoUseCase(SalvarProdutoOutputPort outputPort) {
        this.outputPort = outputPort;
    }

    @Override
    public ProdutoDTO salvar(ProdutoDTO produto) {
        return outputPort.salvar(produto);
    }
}