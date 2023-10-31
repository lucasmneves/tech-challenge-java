package com.fiap.fiapburger.application.ports.out.pedido;

import com.fiap.fiapburger.application.core.domain.PedidoDTO;

public interface AvaliarPedidoOutputPort {
    void avaliar(PedidoDTO pedido);
}
