package com.fiap.fiapburger.application.core.usecase;

import com.fiap.fiapburger.application.core.domain.ProdutoDTO;
import com.fiap.fiapburger.application.ports.in.BuscarProdutoInputPort;
import com.fiap.fiapburger.application.ports.out.BuscarProdutoOutputPort;

public class BuscarProdutoUseCase implements BuscarProdutoInputPort {

    private final BuscarProdutoOutputPort outputPort;

    public BuscarProdutoUseCase(BuscarProdutoOutputPort outputPort) {
        this.outputPort = outputPort;
    }

    @Override
    public ProdutoDTO buscar(Long id) {
        return outputPort.buscar(id);
    }
}