package com.fiap.fiapburger.core.ports.in.pedido;

import com.fiap.fiapburger.infraestructure.api.requests.AvaliarPedidoRequest;

public interface AvaliarPedidoInputPort {
    void avaliar(AvaliarPedidoRequest pedido);
}
