package com.fiap.fiapburger.core.usecase.pedido;

import com.fiap.fiapburger.adapter.in.controller.mapper.PedidoMapper;
import com.fiap.fiapburger.adapter.in.controller.request.SalvarPedidoRequest;
import com.fiap.fiapburger.adapter.in.controller.response.SalvarPedidoResponse;
import com.fiap.fiapburger.core.ports.in.pedido.SalvarPedidoInputPort;
import com.fiap.fiapburger.core.ports.out.pedido.SalvarPedidoOutputPort;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class SalvarPedidoUseCase implements SalvarPedidoInputPort {

    private final SalvarPedidoOutputPort salvarPedidoOutputPort;

    private final PedidoMapper pedidoMapper;

    public SalvarPedidoUseCase(SalvarPedidoOutputPort salvarPedidoOutputPort, PedidoMapper pedidoMapper) {
        this.salvarPedidoOutputPort = salvarPedidoOutputPort;
        this.pedidoMapper = pedidoMapper;
    }
    @Override
    public SalvarPedidoResponse salvar(SalvarPedidoRequest pedidoRequest) {

        var pedidoDto = pedidoMapper.toPedido(pedidoRequest);

        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());

        UUID id = UUID.randomUUID();
        pedidoDto.setId(id.toString());
        pedidoDto.setId_status("1");
        BigDecimal valor = new BigDecimal("0");
        pedidoDto.setValor_total(valor);
        pedidoDto.setData_hora_inicio(date);
        pedidoDto.setId_pagamento("0");
        pedidoDto.setId_satisfacao("0");

        var pedidoSalvo = salvarPedidoOutputPort.salvar(pedidoDto);

        SalvarPedidoResponse response = new SalvarPedidoResponse();
        response.setId(pedidoSalvo.getId());
        return response;
    }
}
