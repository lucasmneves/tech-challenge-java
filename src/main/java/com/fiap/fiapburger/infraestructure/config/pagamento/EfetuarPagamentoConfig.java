package com.fiap.fiapburger.infraestructure.config.pagamento;

import com.fiap.fiapburger.infraestructure.adapters.pagamento.EfetuarPagamentoAdapter;
import com.fiap.fiapburger.core.usecase.pagamento.EfetuarPagamentoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EfetuarPagamentoConfig {
    @Bean
    public EfetuarPagamentoUseCase EfetuarPagamentoUseCase(EfetuarPagamentoAdapter efetuarPagamentoAdapter){
        return new EfetuarPagamentoUseCase(efetuarPagamentoAdapter);
    };
}


