package com.fiap.fiapburger.core.ports.in.pedido;

import com.fiap.fiapburger.adapter.in.controller.request.SalvarPedidoRequest;
import com.fiap.fiapburger.adapter.in.controller.response.SalvarPedidoResponse;

public interface SalvarPedidoInputPort {
    SalvarPedidoResponse salvar(SalvarPedidoRequest pedido);
}
