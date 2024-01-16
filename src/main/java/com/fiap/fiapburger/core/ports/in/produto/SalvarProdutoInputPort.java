package com.fiap.fiapburger.core.ports.in.produto;

import com.fiap.fiapburger.core.domain.entities.ProdutoDTO;

public interface SalvarProdutoInputPort {
    void salvar(ProdutoDTO produto);
}