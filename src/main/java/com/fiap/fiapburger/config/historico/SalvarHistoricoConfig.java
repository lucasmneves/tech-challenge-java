package com.fiap.fiapburger.config.historico;

import com.fiap.fiapburger.adapter.out.historico.SalvarHistoricoAdapter;
import com.fiap.fiapburger.core.usecase.historico.SalvarHistoricoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SalvarHistoricoConfig {
    @Bean
    public SalvarHistoricoUseCase salvarHistoricoUseCase(SalvarHistoricoAdapter salvarClienteAdapter) {
        return new SalvarHistoricoUseCase(salvarClienteAdapter);
    }
}
