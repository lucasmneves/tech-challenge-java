package com.fiap.fiapburger.config.pagamento;

import com.fiap.fiapburger.adapter.out.pagamento.EfetuarPagamentoAdapter;
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


