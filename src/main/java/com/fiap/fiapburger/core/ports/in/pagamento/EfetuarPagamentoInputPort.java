package com.fiap.fiapburger.core.ports.in.pagamento;

import com.fiap.fiapburger.adapter.in.controller.response.EfetuarPagamentoResponse;

public interface EfetuarPagamentoInputPort {
    EfetuarPagamentoResponse efetuarPagamento(EfetuarPagamentoResponse efetuarPagamentoResponse);
}
