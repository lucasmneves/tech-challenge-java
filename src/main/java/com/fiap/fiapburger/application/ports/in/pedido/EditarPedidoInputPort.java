package com.fiap.fiapburger.application.ports.in.pedido;

import com.fiap.fiapburger.application.core.domain.ItensPedidoDTO;
import com.fiap.fiapburger.application.core.domain.PedidoDTO;

public interface EditarPedidoInputPort {
    void adicionarItens(ItensPedidoDTO pedido);
    void editar(PedidoDTO pedido, ItensPedidoDTO itensPedido);

    void atualizarStatusPedido(PedidoDTO pedido);
}
