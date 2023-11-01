package com.fiap.fiapburger.application.ports.out.pedido;


import com.fiap.fiapburger.application.core.domain.ClienteDTO;
import com.fiap.fiapburger.application.core.domain.PedidoDTO;

public interface SalvarPedidoOutputPort {
    void salvar(PedidoDTO pedido);
}
