package com.fiap.fiapburger.application.ports.out.pedido;


import com.fiap.fiapburger.application.core.domain.ItensPedidoDTO;
import com.fiap.fiapburger.application.core.domain.PedidoDTO;

public interface EditarPedidoOutputPort {
    void adicionarItens(ItensPedidoDTO itensPedido);
    void editar(PedidoDTO pedido, ItensPedidoDTO itensPedido);
}
