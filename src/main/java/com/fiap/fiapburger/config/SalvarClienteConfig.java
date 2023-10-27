package com.fiap.fiapburger.config;

import com.fiap.fiapburger.adapter.out.SalvarClienteAdapter;
import com.fiap.fiapburger.application.core.usecase.SalvarClienteUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SalvarClienteConfig {
    @Bean
    public SalvarClienteUseCase salvarClienteUseCase(SalvarClienteAdapter salvarClienteAdapter)
    {
        return new SalvarClienteUseCase(salvarClienteAdapter);
    }
}
