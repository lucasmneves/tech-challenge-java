package com.fiap.fiapburger.config.cliente;

import com.fiap.fiapburger.adapter.in.controller.mapper.ClienteMapper;
import com.fiap.fiapburger.adapter.out.cliente.SalvarClienteAdapter;
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
