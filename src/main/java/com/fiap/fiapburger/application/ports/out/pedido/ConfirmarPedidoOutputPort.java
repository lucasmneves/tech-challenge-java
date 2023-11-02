package com.fiap.fiapburger.application.ports.out.pedido;

import com.fiap.fiapburger.application.core.domain.PedidoDTO;

public interface ConfirmarPedidoOutputPort {
    void confirmar(PedidoDTO pedido);
}
