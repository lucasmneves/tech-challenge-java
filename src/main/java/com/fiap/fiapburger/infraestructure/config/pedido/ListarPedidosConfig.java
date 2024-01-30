package com.fiap.fiapburger.infraestructure.config.pedido;

import com.fiap.fiapburger.infraestructure.adapters.pedido.ListarPedidosAdapter;
import com.fiap.fiapburger.core.usecase.pedido.ListarPedidosUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ListarPedidosConfig {
    @Bean
    public ListarPedidosUseCase listarPedidosUseCase(ListarPedidosAdapter listarPedidosAdapter){
        return new ListarPedidosUseCase(listarPedidosAdapter);
    };
}
