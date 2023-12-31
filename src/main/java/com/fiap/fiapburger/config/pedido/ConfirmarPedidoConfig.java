package com.fiap.fiapburger.config.pedido;

import com.fiap.fiapburger.adapter.out.pedido.ConfirmarPedidoAdapter;
import com.fiap.fiapburger.adapter.out.pedido.EditarPedidoAdapter;
import com.fiap.fiapburger.application.core.usecase.pedido.ConfirmarPedidoUseCase;
import com.fiap.fiapburger.application.core.usecase.pedido.EditarPedidoUseCase;
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

