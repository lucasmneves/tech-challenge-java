package com.fiap.fiapburger.config.cliente;

import com.fiap.fiapburger.adapter.out.cliente.SalvarClienteAdapter;
import com.fiap.fiapburger.application.core.usecase.cliente.SalvarClienteUseCase;
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
