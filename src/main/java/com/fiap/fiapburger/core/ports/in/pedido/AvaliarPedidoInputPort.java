package com.fiap.fiapburger.core.ports.in.pedido;

import com.fiap.fiapburger.adapter.in.controller.request.AvaliarPedidoRequest;
import com.fiap.fiapburger.core.domain.entities.PedidoDTO;

public interface AvaliarPedidoInputPort {
    void avaliar(AvaliarPedidoRequest pedido);
}
