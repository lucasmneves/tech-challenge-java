package com.fiap.fiapburger.core.ports.out.pedido;

import com.fiap.fiapburger.core.domain.entities.PedidoDTO;

public interface ConfirmarPedidoOutputPort {
    void confirmar(PedidoDTO pedido);
}
