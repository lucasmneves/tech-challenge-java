package com.fiap.fiapburger.core.ports.in.pagamento;

import com.fiap.fiapburger.infraestructure.api.responses.WebhookPagamentoResponse;

public interface WebhookPagamentoInputPort {
    WebhookPagamentoResponse webhookPagamento(WebhookPagamentoResponse webhookPagamentoResponse);
}
