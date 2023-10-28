package com.fiap.fiapburger.adapter.in.controller.mapper;

import com.fiap.fiapburger.adapter.in.controller.request.SalvarPedidoRequest;
import com.fiap.fiapburger.adapter.in.controller.response.PedidoResponse;
import com.fiap.fiapburger.adapter.out.repository.entity.PedidoEntity;
import com.fiap.fiapburger.application.core.domain.PedidoDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface PedidoMapper {

    PedidoDTO toPedido(SalvarPedidoRequest salvarPedidoRequest);
    PedidoResponse toPedidoResponse(PedidoEntity pedidoEntity);
}
