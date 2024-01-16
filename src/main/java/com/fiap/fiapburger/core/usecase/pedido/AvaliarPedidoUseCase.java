package com.fiap.fiapburger.core.usecase.pedido;

import com.fiap.fiapburger.core.domain.entities.PedidoDTO;
import com.fiap.fiapburger.core.ports.in.pedido.AvaliarPedidoInputPort;
import com.fiap.fiapburger.core.ports.out.pedido.AvaliarPedidoOutputPort;

public class AvaliarPedidoUseCase implements AvaliarPedidoInputPort {

    private final AvaliarPedidoOutputPort avaliarPedidoOutputPort;

    public AvaliarPedidoUseCase(AvaliarPedidoOutputPort avaliarPedidoOutputPort) {
        this.avaliarPedidoOutputPort = avaliarPedidoOutputPort;
    }

    @Override
    public void avaliar(PedidoDTO pedidoDTO) {
        avaliarPedidoOutputPort.avaliar(pedidoDTO);
    }
}
