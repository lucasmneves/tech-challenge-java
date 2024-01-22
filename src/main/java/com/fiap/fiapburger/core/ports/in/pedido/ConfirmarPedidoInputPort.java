package com.fiap.fiapburger.core.ports.in.pedido;

import com.fiap.fiapburger.adapter.in.controller.request.ConfirmarPedidoRequest;
import com.fiap.fiapburger.core.domain.entities.PedidoDTO;

public interface ConfirmarPedidoInputPort {
    void confirmar(ConfirmarPedidoRequest pedidoRequest);
}
