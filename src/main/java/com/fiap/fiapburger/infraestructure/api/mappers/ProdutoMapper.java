package com.fiap.fiapburger.infraestructure.api.mappers;

import com.fiap.fiapburger.infraestructure.api.requests.ProdutoRequest;
import com.fiap.fiapburger.infraestructure.api.responses.ProdutoResponse;
import com.fiap.fiapburger.core.domain.entities.ProdutoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {

    ProdutoDTO toProdutoDTO(ProdutoRequest produtoRequest);

    @Mapping(source="id_categoria", target = "categoria")
    ProdutoResponse toProdutoResponse(ProdutoDTO produtoDTO);

}