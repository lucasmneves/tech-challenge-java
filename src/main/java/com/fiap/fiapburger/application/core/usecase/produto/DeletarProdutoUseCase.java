package com.fiap.fiapburger.application.core.usecase.produto;


import com.fiap.fiapburger.application.ports.in.produto.DeletarProdutoInputPort;
import com.fiap.fiapburger.application.ports.out.produto.DeletarProdutoOutputPort;
import org.springframework.beans.factory.annotation.Autowired;


public class DeletarProdutoUseCase implements DeletarProdutoInputPort {

    private final DeletarProdutoOutputPort deletarProdutoOutputPort;

    @Autowired
    public DeletarProdutoUseCase(DeletarProdutoOutputPort deletarProdutoOutputPort) {
        this.deletarProdutoOutputPort = deletarProdutoOutputPort;
    }

    @Override
    public void deletar(String id) {
        deletarProdutoOutputPort.deletar(id);
    }
}