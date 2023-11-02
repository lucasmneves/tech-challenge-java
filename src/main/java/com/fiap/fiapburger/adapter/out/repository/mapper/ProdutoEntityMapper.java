package com.fiap.fiapburger.adapter.out.repository.mapper;

import com.fiap.fiapburger.adapter.out.repository.entity.ProdutoEntity;
import com.fiap.fiapburger.application.core.domain.ProdutoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProdutoEntityMapper {

    @Mapping(source="id_Categoria", target = "idCategoria")
    @Mapping(source = "url_Imagem", target = "urlImagem")
    ProdutoDTO toProdutoDTO(ProdutoEntity produtoEntity);
    ProdutoEntity toProdutoEntity(ProdutoDTO produtoDTO);

    void updateEntityFromDTO(ProdutoDTO produtoDTO, @MappingTarget ProdutoEntity produtoEntity);
}