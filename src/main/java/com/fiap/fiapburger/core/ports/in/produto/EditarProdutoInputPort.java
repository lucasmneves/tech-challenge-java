package com.fiap.fiapburger.core.ports.in.produto;

import com.fiap.fiapburger.adapter.in.controller.request.ProdutoRequest;
import com.fiap.fiapburger.core.domain.entities.ProdutoDTO;

public interface EditarProdutoInputPort {
    ProdutoDTO editar(String id, ProdutoRequest produtoRequest);
}