package com.fiap.fiapburger.application.ports.in.pagamento;

import com.fiap.fiapburger.adapter.in.controller.response.WebhookPagamentoResponse;

public interface WebhookPagamentoInputPort {
    WebhookPagamentoResponse webhookPagamento(WebhookPagamentoResponse webhookPagamentoResponse);
}
