package com.fiap.fiapburger.config.pedido;

import com.fiap.fiapburger.adapter.out.pedido.AvaliarPedidoAdapter;
import com.fiap.fiapburger.adapter.out.pedido.ConfirmarPedidoAdapter;
import com.fiap.fiapburger.application.core.usecase.pedido.AvaliarPedidoUseCase;
import com.fiap.fiapburger.application.core.usecase.pedido.ConfirmarPedidoUseCase;
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

