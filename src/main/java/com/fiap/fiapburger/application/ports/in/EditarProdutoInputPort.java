package com.fiap.fiapburger.application.ports.in;

import com.fiap.fiapburger.application.core.domain.ProdutoDTO;

public interface EditarProdutoInputPort {
    void editar(ProdutoDTO produto);
}
