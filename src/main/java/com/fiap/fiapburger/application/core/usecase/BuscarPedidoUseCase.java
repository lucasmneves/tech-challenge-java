
package com.fiap.fiapburger.application.core.usecase;

import com.fiap.fiapburger.adapter.in.controller.response.ClienteResponse;
import com.fiap.fiapburger.adapter.in.controller.response.PedidoResponse;
import com.fiap.fiapburger.application.ports.in.BuscarClienteInputPort;
import com.fiap.fiapburger.application.ports.in.BuscarPedidoInputPort;
import com.fiap.fiapburger.application.ports.out.BuscarClienteOutputPort;
import com.fiap.fiapburger.application.ports.out.BuscarPedidoOutputPort;


public class BuscarPedidoUseCase implements BuscarPedidoInputPort {
    private final BuscarPedidoOutputPort buscarPedidoOutputPort;
    public BuscarPedidoUseCase(BuscarPedidoOutputPort buscarPedidoOutputPort) {
        this.buscarPedidoOutputPort = buscarPedidoOutputPort;
    }
    @Override
    public PedidoResponse buscaPedido(String id) {

       return this.buscarPedidoOutputPort.buscar(id);
    }
}

