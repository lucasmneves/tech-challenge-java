package com.fiap.fiapburger.application.ports.in.produto;

import com.fiap.fiapburger.application.core.domain.ProdutoDTO;

public interface EditarProdutoInputPort {
    ProdutoDTO editar(String id, ProdutoDTO produtoDTO);
}