package com.fiap.fiapburger.adapter.in.controller.mapper;

import com.fiap.fiapburger.adapter.in.controller.request.ProdutoRequest;
import com.fiap.fiapburger.adapter.in.controller.response.ProdutoResponse;
import com.fiap.fiapburger.adapter.out.repository.entity.ProdutoEntity;
import com.fiap.fiapburger.core.domain.entities.ProdutoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {

    ProdutoDTO toProdutoDTO(ProdutoRequest produtoRequest);

    @Mapping(source="id_categoria", target = "categoria")
    ProdutoResponse toProdutoResponse(ProdutoDTO produtoDTO);

    List<ProdutoResponse> toProdutoResponseList(List<ProdutoDTO> produtoDTO);

    List<ProdutoDTO> toProdutoDTOList(List<ProdutoEntity> produtosEntity);
}