package com.fiap.fiapburger.adapter.out.repository.mapper;

import com.fiap.fiapburger.adapter.out.repository.entity.ItensPedidoEntity;
import com.fiap.fiapburger.core.domain.entities.ItensPedidoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItensPedidoEntityMapper {
    ItensPedidoEntity toItensPedidoEntity(ItensPedidoDTO itensPedidoDTO);
}
