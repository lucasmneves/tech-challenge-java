package com.fiap.fiapburger.application.ports.in.pedido;

import com.fiap.fiapburger.adapter.in.controller.response.PedidoResponse;
import com.fiap.fiapburger.application.core.domain.PedidoDTO;

public interface BuscarPedidoInputPort {
    PedidoResponse buscaPedido(PedidoDTO pedido);
}
