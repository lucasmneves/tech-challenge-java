package com.fiap.fiapburger.core.ports.in.pagamento;

import com.fiap.fiapburger.infraestructure.api.responses.ConsultarStatusPagamentoResponse;

public interface ConsultarStatusPagamentoInputPort {
    ConsultarStatusPagamentoResponse consultarStatusPagamento(ConsultarStatusPagamentoResponse consultarStatusPagamentoResponse);
}
