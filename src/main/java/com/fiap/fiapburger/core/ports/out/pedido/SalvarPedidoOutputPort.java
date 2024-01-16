package com.fiap.fiapburger.core.ports.out.pedido;


import com.fiap.fiapburger.core.domain.entities.PedidoDTO;

public interface SalvarPedidoOutputPort {
    void salvar(PedidoDTO pedido);
}
