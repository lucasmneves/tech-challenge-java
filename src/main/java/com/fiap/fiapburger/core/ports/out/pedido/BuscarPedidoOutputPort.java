package com.fiap.fiapburger.core.ports.out.pedido;

import com.fiap.fiapburger.infraestructure.api.responses.PedidoResponse;
import com.fiap.fiapburger.core.domain.entities.PedidoDTO;

public interface BuscarPedidoOutputPort {

    PedidoResponse buscar (PedidoDTO pedido);
}
