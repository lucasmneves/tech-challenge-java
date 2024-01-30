package com.fiap.fiapburger.core.usecase.pedido;

import com.fiap.fiapburger.infraestructure.api.mappers.PedidoMapper;
import com.fiap.fiapburger.infraestructure.api.requests.ConfirmarPedidoRequest;
import com.fiap.fiapburger.core.domain.entities.PedidoDTO;
import com.fiap.fiapburger.core.ports.in.pedido.ConfirmarPedidoInputPort;
import com.fiap.fiapburger.core.ports.out.pedido.ConfirmarPedidoOutputPort;

public class ConfirmarPedidoUseCase implements ConfirmarPedidoInputPort {

    private final ConfirmarPedidoOutputPort confirmarPedidoOutputPort;

    public ConfirmarPedidoUseCase(ConfirmarPedidoOutputPort confirmarPedidoOutputPort) {
        this.confirmarPedidoOutputPort = confirmarPedidoOutputPort;
    }

    @Override
    public void confirmar(ConfirmarPedidoRequest pedidoRequest) {
        PedidoDTO pedido = PedidoMapper.confirmarPedido(pedidoRequest);
        confirmarPedidoOutputPort.confirmar(pedido);
    }
}
