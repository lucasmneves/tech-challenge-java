package com.fiap.fiapburger.infraestructure.config.historico;

import com.fiap.fiapburger.infraestructure.adapters.historico.SalvarHistoricoAdapter;
import com.fiap.fiapburger.infraestructure.persistence.mapper.HistoricoMapper;
import com.fiap.fiapburger.core.usecase.historico.SalvarHistoricoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SalvarHistoricoConfig {
    @Bean
    public SalvarHistoricoUseCase salvarHistoricoUseCase(SalvarHistoricoAdapter salvarClienteAdapter, HistoricoMapper historicoMapper) {
        return new SalvarHistoricoUseCase(salvarClienteAdapter, historicoMapper);
    }
}
