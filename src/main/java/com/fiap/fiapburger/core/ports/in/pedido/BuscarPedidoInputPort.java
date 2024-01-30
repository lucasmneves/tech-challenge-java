package com.fiap.fiapburger.core.ports.in.pedido;

import com.fiap.fiapburger.infraestructure.api.responses.PedidoResponse;

public interface BuscarPedidoInputPort {
    PedidoResponse buscaPedido(String idPedido);
}
