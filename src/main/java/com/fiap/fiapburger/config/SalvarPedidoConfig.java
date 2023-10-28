package com.fiap.fiapburger.config;

import com.fiap.fiapburger.adapter.out.SalvarClienteAdapter;
import com.fiap.fiapburger.adapter.out.SalvarPedidoAdapter;
import com.fiap.fiapburger.application.core.usecase.SalvarClienteUseCase;
import com.fiap.fiapburger.application.core.usecase.SalvarPedidoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SalvarPedidoConfig {
    @Bean
    public SalvarPedidoUseCase salvarPedidoUseCase(SalvarPedidoAdapter salvarPedidoAdapter)
    {
        return new SalvarPedidoUseCase(salvarPedidoAdapter);
    }
}
