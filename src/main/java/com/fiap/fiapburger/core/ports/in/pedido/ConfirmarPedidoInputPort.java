package com.fiap.fiapburger.core.ports.in.pedido;

import com.fiap.fiapburger.infraestructure.api.requests.ConfirmarPedidoRequest;

public interface ConfirmarPedidoInputPort {
    void confirmar(ConfirmarPedidoRequest pedidoRequest);
}
