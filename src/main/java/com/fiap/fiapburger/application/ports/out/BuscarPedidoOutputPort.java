package com.fiap.fiapburger.application.ports.out;

import com.fiap.fiapburger.adapter.in.controller.response.PedidoResponse;

public interface BuscarPedidoOutputPort {

    PedidoResponse buscar (String id);
}
