package com.fiap.fiapburger.adapter.out.repository.mapper;

import com.fiap.fiapburger.adapter.out.repository.entity.ProdutoEntity;
import com.fiap.fiapburger.application.core.domain.ProdutoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProdutoEntityMapper {

    ProdutoEntity toProdutoEntity(ProdutoDTO produtoDTO);

    ProdutoDTO toProdutoDTO(ProdutoEntity produtoEntity);

    void updateEntityFromDTO(ProdutoDTO dto, @MappingTarget ProdutoEntity entity);
}