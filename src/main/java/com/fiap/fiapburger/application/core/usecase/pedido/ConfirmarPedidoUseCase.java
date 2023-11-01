package com.fiap.fiapburger.application.core.usecase.pedido;

import com.fiap.fiapburger.application.core.domain.ItensPedidoDTO;
import com.fiap.fiapburger.application.core.domain.PedidoDTO;
import com.fiap.fiapburger.application.ports.in.pedido.ConfirmarPedidoInputPort;
import com.fiap.fiapburger.application.ports.in.pedido.EditarPedidoInputPort;
import com.fiap.fiapburger.application.ports.out.pedido.ConfirmarPedidoOutputPort;
import com.fiap.fiapburger.application.ports.out.pedido.EditarPedidoOutputPort;

import java.util.UUID;

public class ConfirmarPedidoUseCase implements ConfirmarPedidoInputPort {

    private final ConfirmarPedidoOutputPort confirmarPedidoOutputPort;

    public ConfirmarPedidoUseCase(ConfirmarPedidoOutputPort confirmarPedidoOutputPort) {
        this.confirmarPedidoOutputPort = confirmarPedidoOutputPort;
    }

    @Override
    public void confirmar(PedidoDTO pedidoDTO) {
        confirmarPedidoOutputPort.confirmar(pedidoDTO);
    }
}
