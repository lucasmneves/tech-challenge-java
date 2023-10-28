package com.fiap.fiapburger.application.core.usecase;

import com.fiap.fiapburger.application.core.domain.ClienteDTO;

import com.fiap.fiapburger.application.core.domain.PedidoDTO;
import com.fiap.fiapburger.application.ports.in.SalvarPedidoInputPort;
import com.fiap.fiapburger.application.ports.out.SalvarClienteOutputPort;
import com.fiap.fiapburger.application.ports.out.SalvarPedidoOutputPort;

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
        System.out.println(formatter.format(date));

        /*private String id;
        private String senha;
        private String id_status;
        private String cpf;
        private String detalhes;
        private Double valor_total;
        private Date data_hora_inicio;
        private Date data_hora_fim;
        private String id_pagamento;
        private String id_satisfacao;*/

        UUID id = UUID.randomUUID();

        pedido.setId(id.toString());
        pedido.setSenha("1");
        pedido.setId_status("1");
        //cpf no request
        pedido.setDetalhes("NA");
        BigDecimal valor = new BigDecimal("10");
        pedido.setValor_total(valor);
        pedido.setData_hora_inicio(date);
        pedido.setData_hora_fim(date);
        pedido.setId_pagamento("0");
        pedido.setId_satisfacao("0");

        salvarPedidoOutputPort.salvar(pedido);
    }
}
