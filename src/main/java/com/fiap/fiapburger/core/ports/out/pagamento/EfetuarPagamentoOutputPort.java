package com.fiap.fiapburger.core.ports.out.pagamento;

import com.fiap.fiapburger.adapter.in.controller.response.EfetuarPagamentoResponse;

public interface EfetuarPagamentoOutputPort {
    EfetuarPagamentoResponse efetuarPagamento(EfetuarPagamentoResponse efetuarPagamentoResponse);
}
