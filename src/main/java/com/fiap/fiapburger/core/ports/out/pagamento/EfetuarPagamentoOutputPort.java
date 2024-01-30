package com.fiap.fiapburger.core.ports.out.pagamento;

import com.fiap.fiapburger.infraestructure.api.responses.EfetuarPagamentoResponse;

public interface EfetuarPagamentoOutputPort {
    EfetuarPagamentoResponse efetuarPagamento(EfetuarPagamentoResponse efetuarPagamentoResponse);
}
