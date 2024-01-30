package com.fiap.fiapburger.infraestructure.config.pedido;

import com.fiap.fiapburger.infraestructure.adapters.pedido.AvaliarPedidoAdapter;
import com.fiap.fiapburger.core.usecase.pedido.AvaliarPedidoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AvaliarPedidoConfig {
    @Bean
    public AvaliarPedidoUseCase avaliarPedidoUseCase(AvaliarPedidoAdapter avaliarPedidoAdapter)
    {
        return new AvaliarPedidoUseCase(avaliarPedidoAdapter);
    }
}

