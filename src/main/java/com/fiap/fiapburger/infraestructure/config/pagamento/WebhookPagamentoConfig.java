package com.fiap.fiapburger.infraestructure.config.pagamento;

import com.fiap.fiapburger.core.usecase.pagamento.WebhookPagamentoUseCase;
import com.fiap.fiapburger.infraestructure.adapters.pagamento.WebhookPagamentoAdapter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebhookPagamentoConfig {
    @Bean
    public WebhookPagamentoUseCase webhookPagamentoUseCase(WebhookPagamentoAdapter webhookPagamentoAdapter){
        return new WebhookPagamentoUseCase(webhookPagamentoAdapter);
    };

}


