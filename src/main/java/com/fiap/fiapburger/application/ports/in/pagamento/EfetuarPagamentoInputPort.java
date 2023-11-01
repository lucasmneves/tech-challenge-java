package com.fiap.fiapburger.application.ports.in.pagamento;

import com.fiap.fiapburger.adapter.in.controller.request.EfetuarPagamentoRequest;
import com.fiap.fiapburger.adapter.in.controller.response.EfetuarPagamentoResponse;
import com.fiap.fiapburger.adapter.in.controller.response.PagamentoResponse;

public interface EfetuarPagamentoInputPort {
    EfetuarPagamentoResponse efetuarPagamento(EfetuarPagamentoResponse efetuarPagamentoResponse);
}
