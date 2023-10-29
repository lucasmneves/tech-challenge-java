package com.fiap.fiapburger.application.ports.out;

import com.fiap.fiapburger.application.core.domain.ProdutoDTO;

public interface EditarProdutoOutputPort {
    ProdutoDTO editar(ProdutoDTO produto);
}