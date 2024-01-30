package com.fiap.fiapburger.infraestructure.persistence.mapper;

import com.fiap.fiapburger.infraestructure.persistence.entities.PedidoEntity;
import com.fiap.fiapburger.core.domain.entities.PedidoDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface PedidoEntityMapper {
    PedidoEntity toPedidoEntity(PedidoDTO pedido);
}
