package com.fiap.fiapburger.core.ports.out.produto;

import com.fiap.fiapburger.adapter.out.repository.entity.ProdutoEntity;
import com.fiap.fiapburger.core.domain.entities.ProdutoDTO;

public interface SalvarProdutoOutputPort {
    ProdutoEntity salvar(ProdutoDTO produto);
}