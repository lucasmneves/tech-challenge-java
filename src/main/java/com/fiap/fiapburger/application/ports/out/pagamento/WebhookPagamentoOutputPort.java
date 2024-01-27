package com.fiap.fiapburger.application.ports.out.pagamento;

import com.fiap.fiapburger.adapter.in.controller.response.WebhookPagamentoResponse;

public interface WebhookPagamentoOutputPort {
    WebhookPagamentoResponse webhookPagamento(WebhookPagamentoResponse webhookPagamento);
}
