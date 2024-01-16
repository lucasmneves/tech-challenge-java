package com.fiap.fiapburger.core.ports.in.pedido;

import com.fiap.fiapburger.adapter.in.controller.response.PedidoResponse;
import com.fiap.fiapburger.core.domain.entities.PedidoDTO;

public interface BuscarPedidoInputPort {
    PedidoResponse buscaPedido(PedidoDTO pedido);
}
