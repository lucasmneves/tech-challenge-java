package com.fiap.fiapburger.core.ports.in.pedido;

import com.fiap.fiapburger.core.domain.entities.PedidoDTO;

public interface ConfirmarPedidoInputPort {
    void confirmar(PedidoDTO pedido);
}
