package com.fiap.fiapburger.application.ports.in;

import com.fiap.fiapburger.application.core.domain.PedidoDTO;

public interface SalvarPedidoInputPort {
    void salvar(PedidoDTO pedido);
}
