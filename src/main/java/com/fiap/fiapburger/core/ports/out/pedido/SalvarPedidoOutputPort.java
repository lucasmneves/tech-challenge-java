package com.fiap.fiapburger.core.ports.out.pedido;


import com.fiap.fiapburger.adapter.out.repository.entity.PedidoEntity;
import com.fiap.fiapburger.core.domain.entities.PedidoDTO;

public interface SalvarPedidoOutputPort {
    PedidoEntity salvar(PedidoDTO pedido);
}
