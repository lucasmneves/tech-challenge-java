package com.fiap.fiapburger.application.ports.out.pagamento;

import com.fiap.fiapburger.infraestructure.api.responses.WebhookPagamentoResponse;

public interface WebhookPagamentoOutputPort {
    WebhookPagamentoResponse webhookPagamento(WebhookPagamentoResponse webhookPagamento);
}
