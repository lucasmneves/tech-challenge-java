
package com.fiap.fiapburger.application.core.usecase.pedido;

import com.fiap.fiapburger.adapter.in.controller.response.PedidoResponse;
import com.fiap.fiapburger.application.core.domain.PedidoDTO;
import com.fiap.fiapburger.application.ports.in.pedido.BuscarPedidoInputPort;
import com.fiap.fiapburger.application.ports.out.pedido.BuscarPedidoOutputPort;


public class BuscarPedidoUseCase implements BuscarPedidoInputPort {
    private final BuscarPedidoOutputPort buscarPedidoOutputPort;
    public BuscarPedidoUseCase(BuscarPedidoOutputPort buscarPedidoOutputPort) {
        this.buscarPedidoOutputPort = buscarPedidoOutputPort;
    }
    @Override
    public PedidoResponse buscaPedido(PedidoDTO pedido) {

       return this.buscarPedidoOutputPort.buscar(pedido);
    }
}

