package com.fiap.fiapburger.adapter.out.repository.mapper;

import com.fiap.fiapburger.adapter.out.repository.entity.ProdutoEntity;
import com.fiap.fiapburger.core.domain.entities.ProdutoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProdutoEntityMapper {

    ProdutoDTO toProdutoDTO(ProdutoEntity produtoEntity);
    ProdutoEntity toProdutoEntity(ProdutoDTO produtoDTO);

    void updateEntityFromDTO(ProdutoDTO produtoDTO, @MappingTarget ProdutoEntity produtoEntity);
}