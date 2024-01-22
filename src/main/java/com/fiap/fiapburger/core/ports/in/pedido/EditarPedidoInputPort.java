package com.fiap.fiapburger.core.ports.in.pedido;

import com.fiap.fiapburger.adapter.in.controller.request.AdicionarItensPedidoRequest;
import com.fiap.fiapburger.core.domain.entities.ItensPedidoDTO;
import com.fiap.fiapburger.core.domain.entities.PedidoDTO;

public interface EditarPedidoInputPort {
    void adicionarItens(ItensPedidoDTO pedido);

    void editar(AdicionarItensPedidoRequest itensPedido);

    void atualizarStatusPedido(PedidoDTO pedido);
}
