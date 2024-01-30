package com.fiap.fiapburger.infraestructure.config.pedido;

import com.fiap.fiapburger.infraestructure.api.mappers.PedidoMapper;
import com.fiap.fiapburger.infraestructure.adapters.pedido.SalvarPedidoAdapter;
import com.fiap.fiapburger.core.usecase.pedido.SalvarPedidoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SalvarPedidoConfig {
    @Bean
    public SalvarPedidoUseCase salvarPedidoUseCase(SalvarPedidoAdapter salvarPedidoAdapter, PedidoMapper pedidoMapper)
    {
        return new SalvarPedidoUseCase(salvarPedidoAdapter, pedidoMapper);
    }
}
