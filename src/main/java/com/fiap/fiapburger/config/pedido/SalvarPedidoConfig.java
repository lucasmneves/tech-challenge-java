package com.fiap.fiapburger.config.pedido;

import com.fiap.fiapburger.adapter.in.controller.mapper.PedidoMapper;
import com.fiap.fiapburger.adapter.out.pedido.SalvarPedidoAdapter;
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
