package com.fiap.fiapburger.core.usecase.produto;

import com.fiap.fiapburger.core.domain.entities.ProdutoDTO;
import com.fiap.fiapburger.core.ports.in.produto.BuscarProdutoInputPort;
import com.fiap.fiapburger.core.ports.out.produto.BuscarProdutoOutputPort;
import org.springframework.beans.factory.annotation.Autowired;



public class BuscarProdutoUseCase implements BuscarProdutoInputPort {

    private final BuscarProdutoOutputPort buscarProdutoOutputPort;

    public BuscarProdutoUseCase(BuscarProdutoOutputPort buscarProdutoOutputPort) {
        this.buscarProdutoOutputPort = buscarProdutoOutputPort;
    }

    @Override
    public ProdutoDTO buscar(String id) {
        return buscarProdutoOutputPort.buscar(id);
    }
}