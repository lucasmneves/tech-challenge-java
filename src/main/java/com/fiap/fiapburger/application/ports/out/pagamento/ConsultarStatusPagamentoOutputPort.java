package com.fiap.fiapburger.application.ports.out.pagamento;

import com.fiap.fiapburger.adapter.in.controller.response.ConsultarStatusPagamentoResponse;

public interface ConsultarStatusPagamentoOutputPort {
    ConsultarStatusPagamentoResponse consultarStatusPagamento(ConsultarStatusPagamentoResponse consultarStatusPagamento);
}
