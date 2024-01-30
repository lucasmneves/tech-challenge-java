package com.fiap.fiapburger.infraestructure.config.pedido;

import com.fiap.fiapburger.infraestructure.adapters.pedido.ConfirmarPedidoAdapter;
import com.fiap.fiapburger.core.usecase.pedido.ConfirmarPedidoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfirmarPedidoConfig {
    @Bean
    public ConfirmarPedidoUseCase confirmarPedidoUseCase(ConfirmarPedidoAdapter confirmarPedidoAdapter)
    {
        return new ConfirmarPedidoUseCase(confirmarPedidoAdapter);
    }
}

