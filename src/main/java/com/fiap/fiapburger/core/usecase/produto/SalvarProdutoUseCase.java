package com.fiap.fiapburger.core.usecase.produto;

import com.fiap.fiapburger.infraestructure.api.mappers.ProdutoMapper;
import com.fiap.fiapburger.infraestructure.api.requests.ProdutoRequest;
import com.fiap.fiapburger.core.domain.entities.ProdutoDTO;

import com.fiap.fiapburger.core.ports.in.produto.SalvarProdutoInputPort;
import com.fiap.fiapburger.core.ports.out.produto.SalvarProdutoOutputPort;

import java.util.UUID;

public class SalvarProdutoUseCase implements SalvarProdutoInputPort {

    private final SalvarProdutoOutputPort outputPort;
    private final ProdutoMapper produtoMapper;
    public SalvarProdutoUseCase(SalvarProdutoOutputPort outputPort, ProdutoMapper produtoMapper) {
        this.outputPort = outputPort;
        this.produtoMapper = produtoMapper;
    }

    @Override
    public ProdutoDTO salvar(ProdutoRequest produtoRequest) {
        ProdutoDTO produtoDTO = produtoMapper.toProdutoDTO(produtoRequest);
        UUID id = UUID.randomUUID();
        produtoDTO.setId(id.toString());
        outputPort.salvar(produtoDTO);
        return produtoDTO;
    }
}