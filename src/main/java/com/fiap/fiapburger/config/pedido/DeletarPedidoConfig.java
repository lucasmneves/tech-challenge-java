package com.fiap.fiapburger.config.pedido;

import com.fiap.fiapburger.adapter.out.cliente.DeletarClienteAdapter;
import com.fiap.fiapburger.adapter.out.pedido.DeletarPedidoAdapter;
import com.fiap.fiapburger.application.core.usecase.cliente.DeletarClienteUseCase;
import com.fiap.fiapburger.application.core.usecase.pedido.DeletarPedidoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeletarPedidoConfig {
    @Bean
    public DeletarPedidoUseCase deletarPedidoUseCase(DeletarPedidoAdapter deletarPedidoAdapter){
        return new DeletarPedidoUseCase(deletarPedidoAdapter);
    }
}

