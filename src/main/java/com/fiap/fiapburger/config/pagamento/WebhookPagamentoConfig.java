package com.fiap.fiapburger.config.pagamento;

import com.fiap.fiapburger.adapter.out.pagamento.WebhookPagamentoAdapter;
import com.fiap.fiapburger.application.core.usecase.pagamento.WebhookPagamentoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebhookPagamentoConfig {

    @Bean
    public WebhookPagamentoUseCase webhookPagamentoUseCase(WebhookPagamentoAdapter webhookPagamentoAdapter){
        return new WebhookPagamentoUseCase(webhookPagamentoAdapter);
    };

}


