package com.fiap.fiapburger.config.pedido;

import com.fiap.fiapburger.adapter.out.pedido.ListarPedidosAdapter;
import com.fiap.fiapburger.application.core.usecase.pedido.ListarPedidosUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ListarPedidosConfig {
    @Bean
    public ListarPedidosUseCase listarPedidosUseCase(ListarPedidosAdapter listarPedidosAdapter){
        return new ListarPedidosUseCase(listarPedidosAdapter);
    };
}
