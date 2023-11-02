package com.fiap.fiapburger.config.historico;

import com.fiap.fiapburger.adapter.out.cliente.SalvarClienteAdapter;
import com.fiap.fiapburger.adapter.out.historico.SalvarHistoricoAdapter;
import com.fiap.fiapburger.application.core.usecase.historico.SalvarHistoricoUseCase;
import com.fiap.fiapburger.application.ports.out.historico.SalvarHistoricoOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SalvarHistoricoConfig {
    @Bean
    public SalvarHistoricoUseCase salvarHistoricoUseCase(SalvarHistoricoAdapter salvarClienteAdapter) {
        return new SalvarHistoricoUseCase(salvarClienteAdapter);
    }
}
