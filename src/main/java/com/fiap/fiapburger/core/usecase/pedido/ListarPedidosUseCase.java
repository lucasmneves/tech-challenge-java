package com.fiap.fiapburger.core.usecase.pedido;

import com.fiap.fiapburger.infraestructure.api.responses.PedidoResponse;
import com.fiap.fiapburger.core.ports.in.pedido.ListarPedidosInputPort;
import com.fiap.fiapburger.core.ports.out.pedido.ListarPedidosOutputPort;

import java.util.List;

public class ListarPedidosUseCase implements ListarPedidosInputPort {

    private final ListarPedidosOutputPort listarPedidosOutputPort;

    public ListarPedidosUseCase(ListarPedidosOutputPort listarPedidosOutputPort) {
        this.listarPedidosOutputPort = listarPedidosOutputPort;
    }

    @Override
    public List<PedidoResponse> listaPedidos() {
        return this.listarPedidosOutputPort.listaPedidos();
    }

    @Override
    public List<PedidoResponse> listaPedidosPorStatus(String id_status) {
        return this.listarPedidosOutputPort.listaPedidosPorStatus(id_status);
    }
}
