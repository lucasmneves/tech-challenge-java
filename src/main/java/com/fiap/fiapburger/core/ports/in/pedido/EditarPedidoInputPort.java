package com.fiap.fiapburger.core.ports.in.pedido;

import com.fiap.fiapburger.core.domain.entities.ItensPedidoDTO;
import com.fiap.fiapburger.core.domain.entities.PedidoDTO;

public interface EditarPedidoInputPort {
    void adicionarItens(ItensPedidoDTO pedido);
    void editar(PedidoDTO pedido, ItensPedidoDTO itensPedido);

    void atualizarStatusPedido(PedidoDTO pedido);
}
