package com.fiap.fiapburger.application.ports.in.pedido;

import com.fiap.fiapburger.application.core.domain.PedidoDTO;

public interface SalvarPedidoInputPort {
    void salvar(PedidoDTO pedido);
}
