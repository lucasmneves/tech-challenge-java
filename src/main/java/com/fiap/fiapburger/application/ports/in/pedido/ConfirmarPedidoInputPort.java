package com.fiap.fiapburger.application.ports.in.pedido;

import com.fiap.fiapburger.application.core.domain.PedidoDTO;

public interface ConfirmarPedidoInputPort {
    void confirmar(PedidoDTO pedido);
}
