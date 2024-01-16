package com.fiap.fiapburger.core.usecase.produto;

import com.fiap.fiapburger.core.domain.entities.ProdutoDTO;

import com.fiap.fiapburger.core.ports.in.produto.SalvarProdutoInputPort;
import com.fiap.fiapburger.core.ports.out.produto.SalvarProdutoOutputPort;

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