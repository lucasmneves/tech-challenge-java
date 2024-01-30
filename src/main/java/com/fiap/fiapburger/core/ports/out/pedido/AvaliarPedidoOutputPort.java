package com.fiap.fiapburger.core.ports.out.pedido;

import com.fiap.fiapburger.core.domain.entities.PedidoDTO;

public interface AvaliarPedidoOutputPort {
    void avaliar(PedidoDTO pedido);
}
