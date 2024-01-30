package com.fiap.fiapburger.core.ports.in.pagamento;

import com.fiap.fiapburger.infraestructure.api.responses.EfetuarPagamentoResponse;

public interface EfetuarPagamentoInputPort {
    EfetuarPagamentoResponse efetuarPagamento(EfetuarPagamentoResponse efetuarPagamentoResponse);
}
