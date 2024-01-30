package com.fiap.fiapburger.core.ports.out.pedido;

import com.fiap.fiapburger.infraestructure.api.responses.PedidoResponse;
import java.util.List;
public interface ListarPedidosOutputPort {
    List<PedidoResponse> listaPedidos();
    List<PedidoResponse> listaPedidosPorStatus(String id_status);
}
