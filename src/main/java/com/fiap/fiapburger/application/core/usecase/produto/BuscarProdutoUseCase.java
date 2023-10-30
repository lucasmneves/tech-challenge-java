package com.fiap.fiapburger.application.core.usecase.produto;

import com.fiap.fiapburger.application.core.domain.ProdutoDTO;
import com.fiap.fiapburger.application.ports.in.BuscarProdutoInputPort;
import com.fiap.fiapburger.application.ports.out.BuscarProdutoOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class BuscarProdutoUseCase implements BuscarProdutoInputPort {

    private final BuscarProdutoOutputPort buscarProdutoOutputPort;

    @Autowired
    public BuscarProdutoUseCase(BuscarProdutoOutputPort buscarProdutoOutputPort) {
        this.buscarProdutoOutputPort = buscarProdutoOutputPort;
    }

    @Override
    public ProdutoDTO buscar(String id) {
        return buscarProdutoOutputPort.buscar(id);
    }
}