package com.fiap.fiapburger.adapter.out.repository.mapper;

import com.fiap.fiapburger.adapter.out.repository.entity.ItensPedidoEntity;
import com.fiap.fiapburger.adapter.out.repository.entity.PedidoEntity;
import com.fiap.fiapburger.application.core.domain.ItensPedidoDTO;
import com.fiap.fiapburger.application.core.domain.PedidoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItensPedidoEntityMapper {
    ItensPedidoEntity toItensPedidoEntity(ItensPedidoDTO itensPedidoDTO);
}
