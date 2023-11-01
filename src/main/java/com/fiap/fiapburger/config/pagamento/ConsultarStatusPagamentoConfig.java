package com.fiap.fiapburger.config.pagamento;

import com.fiap.fiapburger.adapter.out.pagamento.ConsultarStatusPagamentoAdapter;
import com.fiap.fiapburger.adapter.out.pagamento.EfetuarPagamentoAdapter;
import com.fiap.fiapburger.application.core.usecase.pagamento.ConsultarStatusPagamentoUseCase;
import com.fiap.fiapburger.application.core.usecase.pagamento.EfetuarPagamentoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsultarStatusPagamentoConfig {

    @Bean
    public ConsultarStatusPagamentoUseCase consultarStatusPagamentoUseCase(ConsultarStatusPagamentoAdapter consultarStatusPagamentoAdapter){
        return new ConsultarStatusPagamentoUseCase(consultarStatusPagamentoAdapter);
    };

}


