package com.fiap.fiapburger.application.ports.out.pagamento;

import com.fiap.fiapburger.adapter.in.controller.response.ConsultarStatusPagamentoResponse;
import com.fiap.fiapburger.adapter.in.controller.response.EfetuarPagamentoResponse;
import com.fiap.fiapburger.application.ports.in.pagamento.ConsultarStatusPagamentoInputPort;

public interface ConsultarStatusPagamentoOutputPort {
    ConsultarStatusPagamentoResponse consultarStatusPagamento(ConsultarStatusPagamentoResponse consultarStatusPagamentoResponse);
}
