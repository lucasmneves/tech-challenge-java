package com.fiap.fiapburger.core.ports.in.pedido;

import com.fiap.fiapburger.infraestructure.api.requests.SalvarPedidoRequest;
import com.fiap.fiapburger.infraestructure.api.responses.SalvarPedidoResponse;

public interface SalvarPedidoInputPort {
    SalvarPedidoResponse salvar(SalvarPedidoRequest pedido);
}
