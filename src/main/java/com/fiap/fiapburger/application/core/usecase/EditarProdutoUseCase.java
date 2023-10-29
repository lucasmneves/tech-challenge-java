package com.fiap.fiapburger.application.core.usecase;

import com.fiap.fiapburger.application.core.domain.ProdutoDTO;
import com.fiap.fiapburger.application.ports.in.EditarProdutoInputPort;
import com.fiap.fiapburger.application.ports.out.EditarProdutoOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EditarProdutoUseCase implements EditarProdutoInputPort {

    private final EditarProdutoOutputPort editarProdutoOutputPort;

    @Autowired
    public EditarProdutoUseCase(EditarProdutoOutputPort editarProdutoOutputPort) {
        this.editarProdutoOutputPort = editarProdutoOutputPort;
    }

    @Override
    public ProdutoDTO editar(String id, ProdutoDTO produtoDTO) {
        return editarProdutoOutputPort.editar(id, produtoDTO);
    }
}