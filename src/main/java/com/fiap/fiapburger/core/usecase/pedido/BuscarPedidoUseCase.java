
package com.fiap.fiapburger.core.usecase.pedido;

import com.fiap.fiapburger.infraestructure.api.responses.PedidoResponse;
import com.fiap.fiapburger.core.domain.entities.PedidoDTO;
import com.fiap.fiapburger.core.ports.in.pedido.BuscarPedidoInputPort;
import com.fiap.fiapburger.core.ports.out.pedido.BuscarPedidoOutputPort;


public class BuscarPedidoUseCase implements BuscarPedidoInputPort {
    private final BuscarPedidoOutputPort buscarPedidoOutputPort;
    public BuscarPedidoUseCase(BuscarPedidoOutputPort buscarPedidoOutputPort) {
        this.buscarPedidoOutputPort = buscarPedidoOutputPort;
    }
    @Override
    public PedidoResponse buscaPedido(String idPedido) {
        PedidoDTO pedidoDTO = new PedidoDTO();
        pedidoDTO.setId(idPedido);
        return this.buscarPedidoOutputPort.buscar(pedidoDTO);
    }
}

