package com.fiap.fiapburger.infraestructure.config.pagamento;

import com.fiap.fiapburger.infraestructure.adapters.pagamento.ConsultarStatusPagamentoAdapter;
import com.fiap.fiapburger.core.usecase.pagamento.ConsultarStatusPagamentoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class ConsultarStatusPagamentoConfig {
    @Bean
    public ConsultarStatusPagamentoUseCase consultarStatusPagamentoUseCase(ConsultarStatusPagamentoAdapter consultarStatusPagamentoAdapter){
        return new ConsultarStatusPagamentoUseCase(consultarStatusPagamentoAdapter);
    };

}


