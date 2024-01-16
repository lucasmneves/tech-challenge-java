package com.fiap.fiapburger.core.ports.out.produto;

import com.fiap.fiapburger.core.domain.entities.ProdutoDTO;

public interface SalvarProdutoOutputPort {
    void salvar(ProdutoDTO produto);
}