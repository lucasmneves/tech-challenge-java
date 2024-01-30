package com.fiap.fiapburger.core.ports.out.produto;

import com.fiap.fiapburger.core.domain.entities.ProdutoDTO;

public interface EditarProdutoOutputPort {
    ProdutoDTO editar(String id, ProdutoDTO produtoDTO);
}