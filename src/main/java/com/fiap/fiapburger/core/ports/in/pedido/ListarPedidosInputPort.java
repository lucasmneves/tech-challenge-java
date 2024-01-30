package com.fiap.fiapburger.core.ports.in.pedido;

import com.fiap.fiapburger.infraestructure.api.responses.PedidoResponse;
import java.util.List;

public interface ListarPedidosInputPort {
    List<PedidoResponse> listaPedidos();

    List<PedidoResponse> listaPedidosPorStatus(String id_status);
}
