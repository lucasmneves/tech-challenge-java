package com.fiap.fiapburger.application.ports.out.pedido;

import com.fiap.fiapburger.adapter.in.controller.response.PedidoResponse;

public interface BuscarPedidoOutputPort {

    PedidoResponse buscar (String id);
}
