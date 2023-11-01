package com.fiap.fiapburger.application.ports.in.produto;

import com.fiap.fiapburger.application.core.domain.ProdutoDTO;

public interface BuscarProdutoInputPort {
    ProdutoDTO buscar(Long id);
}