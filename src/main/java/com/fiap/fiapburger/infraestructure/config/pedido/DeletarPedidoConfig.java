package com.fiap.fiapburger.infraestructure.config.pedido;

import com.fiap.fiapburger.infraestructure.adapters.pedido.DeletarPedidoAdapter;
import com.fiap.fiapburger.core.usecase.pedido.DeletarPedidoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeletarPedidoConfig {
    @Bean
    public DeletarPedidoUseCase deletarPedidoUseCase(DeletarPedidoAdapter deletarPedidoAdapter){
        return new DeletarPedidoUseCase(deletarPedidoAdapter);
    }
}

