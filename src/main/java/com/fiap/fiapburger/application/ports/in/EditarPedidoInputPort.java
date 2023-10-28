package com.fiap.fiapburger.application.ports.in;

import com.fiap.fiapburger.application.core.domain.ItensPedidoDTO;

public interface EditarPedidoInputPort {
    void editar(ItensPedidoDTO pedido);
}
