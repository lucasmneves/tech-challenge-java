package com.fiap.fiapburger.application.core.usecase.produto;

import com.fiap.fiapburger.application.core.domain.ProdutoDTO;
import com.fiap.fiapburger.application.ports.in.produto.BuscarProdutoInputPort;
import com.fiap.fiapburger.application.ports.out.produto.BuscarProdutoOutputPort;
import org.springframework.beans.factory.annotation.Autowired;



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