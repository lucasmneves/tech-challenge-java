package com.fiap.fiapburger.adapter.in.controller.mapper;

import com.fiap.fiapburger.adapter.in.controller.request.EditarPedidoRequest;
import com.fiap.fiapburger.adapter.in.controller.request.SalvarPedidoRequest;
import com.fiap.fiapburger.adapter.in.controller.response.PedidoResponse;
import com.fiap.fiapburger.adapter.out.repository.entity.PedidoEntity;
import com.fiap.fiapburger.adapter.out.repository.mapper.ItensPedidoEntityMapper;
import com.fiap.fiapburger.application.core.domain.ItensPedidoDTO;
import com.fiap.fiapburger.application.core.domain.PedidoDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface PedidoMapper {

    PedidoDTO toPedido(SalvarPedidoRequest salvarPedidoRequest);
    PedidoResponse toPedidoResponse(PedidoEntity pedidoEntity);

    static public ItensPedidoDTO editarPedido(EditarPedidoRequest editarPedidoRequest) {
        ItensPedidoDTO itensPedido = new ItensPedidoDTO();
        itensPedido.setId_pedido(editarPedidoRequest.getIdPedido());
        itensPedido.setId_produto(editarPedidoRequest.getIdProduto().get(0));
        return itensPedido;
    }
}
