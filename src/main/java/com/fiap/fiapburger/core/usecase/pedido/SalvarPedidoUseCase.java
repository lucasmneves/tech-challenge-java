package com.fiap.fiapburger.core.usecase.pedido;

import com.fiap.fiapburger.core.domain.entities.PedidoDTO;
import com.fiap.fiapburger.core.ports.in.pedido.SalvarPedidoInputPort;
import com.fiap.fiapburger.core.ports.out.pedido.SalvarPedidoOutputPort;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class SalvarPedidoUseCase implements SalvarPedidoInputPort {

    private final SalvarPedidoOutputPort salvarPedidoOutputPort;

    public SalvarPedidoUseCase(SalvarPedidoOutputPort salvarPedidoOutputPort) {
        this.salvarPedidoOutputPort = salvarPedidoOutputPort;
    }
    @Override
    public void salvar(PedidoDTO pedido) {

        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());

        UUID id = UUID.randomUUID();
        pedido.setId(id.toString());
        pedido.setId_status("1");
        BigDecimal valor = new BigDecimal("0");
        pedido.setValor_total(valor);
        pedido.setData_hora_inicio(date);
        pedido.setId_pagamento("0");
        pedido.setId_satisfacao("0");

        salvarPedidoOutputPort.salvar(pedido);
    }
}
