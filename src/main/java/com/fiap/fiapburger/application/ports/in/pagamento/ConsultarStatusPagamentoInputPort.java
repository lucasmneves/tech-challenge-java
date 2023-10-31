package com.fiap.fiapburger.application.ports.in.pagamento;

import com.fiap.fiapburger.adapter.in.controller.response.ConsultarStatusPagamentoResponse;
import com.fiap.fiapburger.adapter.in.controller.response.EfetuarPagamentoResponse;

public interface ConsultarStatusPagamentoInputPort {
    ConsultarStatusPagamentoResponse consultarStatusPagamento(ConsultarStatusPagamentoResponse consultarStatusPagamentoResponse);
}
