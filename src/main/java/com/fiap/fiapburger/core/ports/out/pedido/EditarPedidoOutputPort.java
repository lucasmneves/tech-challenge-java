package com.fiap.fiapburger.core.ports.out.pedido;


import com.fiap.fiapburger.core.domain.entities.ItensPedidoDTO;
import com.fiap.fiapburger.core.domain.entities.PedidoDTO;

public interface EditarPedidoOutputPort {
    void adicionarItens(ItensPedidoDTO itensPedido);
    void editar(PedidoDTO pedido, ItensPedidoDTO itensPedido);
    void atualizarStatusPedido(PedidoDTO pedido);
}
