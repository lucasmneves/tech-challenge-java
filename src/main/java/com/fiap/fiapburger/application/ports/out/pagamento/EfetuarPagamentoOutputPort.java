package com.fiap.fiapburger.application.ports.out.pagamento;

import com.fiap.fiapburger.adapter.in.controller.request.EfetuarPagamentoRequest;
import com.fiap.fiapburger.adapter.in.controller.response.EfetuarPagamentoResponse;
import com.fiap.fiapburger.adapter.in.controller.response.PagamentoResponse;

public interface EfetuarPagamentoOutputPort {
    EfetuarPagamentoResponse efetuarPagamento(EfetuarPagamentoResponse efetuarPagamentoResponse);
}
