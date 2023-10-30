package com.fiap.fiapburger.application.ports.in.pedido;

import com.fiap.fiapburger.adapter.in.controller.response.PedidoResponse;

public interface BuscarPedidoInputPort {
    PedidoResponse buscaPedido(String id);
}
