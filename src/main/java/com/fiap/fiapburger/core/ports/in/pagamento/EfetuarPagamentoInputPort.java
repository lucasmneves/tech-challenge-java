package com.fiap.fiapburger.core.ports.in.pagamento;

import com.fiap.fiapburger.adapter.in.controller.request.EfetuarPagamentoRequest;
import com.fiap.fiapburger.adapter.in.controller.response.EfetuarPagamentoResponse;

public interface EfetuarPagamentoInputPort {
    EfetuarPagamentoResponse efetuarPagamento(EfetuarPagamentoRequest efetuarPagamentoRequest);
}
