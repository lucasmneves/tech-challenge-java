package com.fiap.fiapburger.application.ports.out.produto;

import com.fiap.fiapburger.application.core.domain.ProdutoDTO;

public interface BuscarProdutoOutputPort {
    ProdutoDTO buscar(String id);
}