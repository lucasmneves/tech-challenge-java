package com.fiap.fiapburger.adapter.in.controller.mapper;

import com.fiap.fiapburger.adapter.in.controller.request.ProdutoRequest;
import com.fiap.fiapburger.adapter.in.controller.response.ProdutoResponse;
import com.fiap.fiapburger.application.core.domain.ProdutoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "id_categoria", target = "id_categoria")
    ProdutoDTO toProdutoDTO(ProdutoRequest produtoRequest);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "id_categoria", target = "id_categoria")
    ProdutoResponse toProdutoResponse(ProdutoDTO produtoDTO);
}