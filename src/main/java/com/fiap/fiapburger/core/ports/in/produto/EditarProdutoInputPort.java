package com.fiap.fiapburger.core.ports.in.produto;

import com.fiap.fiapburger.core.domain.entities.ProdutoDTO;

public interface EditarProdutoInputPort {
    ProdutoDTO editar(String id, ProdutoDTO produtoDTO);
}