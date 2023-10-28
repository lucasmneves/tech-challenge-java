package com.fiap.fiapburger.application.ports.out;


import com.fiap.fiapburger.application.core.domain.ItensPedidoDTO;

public interface EditarPedidoOutputPort {
    void editar(ItensPedidoDTO itensPedido);
}
