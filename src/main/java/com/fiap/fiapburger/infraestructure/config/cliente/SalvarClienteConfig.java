package com.fiap.fiapburger.infraestructure.config.cliente;

import com.fiap.fiapburger.infraestructure.api.mappers.ClienteMapper;
import com.fiap.fiapburger.infraestructure.adapters.cliente.SalvarClienteAdapter;
import com.fiap.fiapburger.core.usecase.cliente.SalvarClienteUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SalvarClienteConfig {
    @Bean
    public SalvarClienteUseCase salvarClienteUseCase(SalvarClienteAdapter salvarClienteAdapter, ClienteMapper clienteMapper)
    {
        return new SalvarClienteUseCase(salvarClienteAdapter, clienteMapper);
    }
}
