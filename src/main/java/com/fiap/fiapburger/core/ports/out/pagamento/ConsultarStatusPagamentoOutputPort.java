package com.fiap.fiapburger.core.ports.out.pagamento;

import com.fiap.fiapburger.infraestructure.api.responses.ConsultarStatusPagamentoResponse;

public interface ConsultarStatusPagamentoOutputPort {
    ConsultarStatusPagamentoResponse consultarStatusPagamento(ConsultarStatusPagamentoResponse consultarStatusPagamento);
}
