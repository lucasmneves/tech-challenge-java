package com.fiap.fiapburger.application.ports.out.pedido;

import com.fiap.fiapburger.adapter.in.controller.response.PedidoResponse;
import com.fiap.fiapburger.application.core.domain.PedidoDTO;

public interface BuscarPedidoOutputPort {

    PedidoResponse buscar (PedidoDTO pedido);
}
