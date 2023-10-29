package com.fiap.fiapburger.application.ports.in;

import com.fiap.fiapburger.application.core.domain.ProdutoDTO;

public interface BuscarProdutoInputPort {
    ProdutoDTO buscar(String id);
}