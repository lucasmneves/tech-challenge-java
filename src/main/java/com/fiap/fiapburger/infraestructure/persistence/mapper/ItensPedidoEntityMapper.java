package com.fiap.fiapburger.infraestructure.persistence.mapper;

import com.fiap.fiapburger.infraestructure.persistence.entities.ItensPedidoEntity;
import com.fiap.fiapburger.core.domain.entities.ItensPedidoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItensPedidoEntityMapper {
    ItensPedidoEntity toItensPedidoEntity(ItensPedidoDTO itensPedidoDTO);
}
