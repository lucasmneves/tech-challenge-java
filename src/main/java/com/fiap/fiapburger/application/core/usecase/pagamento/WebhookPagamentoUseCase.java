
package com.fiap.fiapburger.application.core.usecase.pagamento;

import com.fiap.fiapburger.adapter.in.controller.response.WebhookPagamentoResponse;
import com.fiap.fiapburger.application.ports.in.pagamento.WebhookPagamentoInputPort;
import com.fiap.fiapburger.application.ports.out.pagamento.WebhookPagamentoOutputPort;


public class WebhookPagamentoUseCase implements WebhookPagamentoInputPort {
    private final WebhookPagamentoOutputPort webhookPagamentoOutputPort;
    public WebhookPagamentoUseCase(WebhookPagamentoOutputPort webhookPagamentoOutputPort) {
        this.webhookPagamentoOutputPort = webhookPagamentoOutputPort;
    }
    @Override
    public WebhookPagamentoResponse webhookPagamento(WebhookPagamentoResponse webhookPagamentoResponse) {

        webhookPagamentoResponse.setStatus("Confirmado");
        webhookPagamentoResponse.setMensagem("Pagamento aprovado!");

        return this.webhookPagamentoOutputPort.webhookPagamento(webhookPagamentoResponse);
    }
}

