package com.fiap.fiapburger.core.usecase.produto;


import com.fiap.fiapburger.core.ports.in.produto.DeletarProdutoInputPort;
import com.fiap.fiapburger.core.ports.out.produto.DeletarProdutoOutputPort;
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