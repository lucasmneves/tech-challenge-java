package com.fiap.fiapburger.application.core.usecase.pedido;

import com.fiap.fiapburger.application.core.domain.PedidoDTO;
import com.fiap.fiapburger.application.ports.in.pedido.AvaliarPedidoInputPort;
import com.fiap.fiapburger.application.ports.in.pedido.ConfirmarPedidoInputPort;
import com.fiap.fiapburger.application.ports.out.pedido.AvaliarPedidoOutputPort;
import com.fiap.fiapburger.application.ports.out.pedido.ConfirmarPedidoOutputPort;

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
