package com.fiap.fiapburger.application.core.usecase.produto;

import com.fiap.fiapburger.application.core.domain.ProdutoDTO;

import com.fiap.fiapburger.application.ports.in.produto.SalvarProdutoInputPort;
import com.fiap.fiapburger.application.ports.out.produto.SalvarProdutoOutputPort;

import java.util.UUID;

public class SalvarProdutoUseCase implements SalvarProdutoInputPort {

    private final SalvarProdutoOutputPort outputPort;

    public SalvarProdutoUseCase(SalvarProdutoOutputPort outputPort) {
        this.outputPort = outputPort;
    }

    @Override
    public void salvar(ProdutoDTO produto) {
        UUID id = UUID.randomUUID();
        produto.setId(id.toString());
        outputPort.salvar(produto);
    }
}