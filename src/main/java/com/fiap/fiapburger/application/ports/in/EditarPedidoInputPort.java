package com.fiap.fiapburger.application.ports.in;

import com.fiap.fiapburger.application.core.domain.ItensPedidoDTO;
import com.fiap.fiapburger.application.core.domain.PedidoDTO;

public interface EditarPedidoInputPort {
    void adicionarItens(ItensPedidoDTO pedido);
    void editar(PedidoDTO pedido, ItensPedidoDTO itensPedido);
}
