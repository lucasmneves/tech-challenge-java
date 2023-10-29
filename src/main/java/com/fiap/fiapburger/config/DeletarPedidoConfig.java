package com.fiap.fiapburger.config;

import com.fiap.fiapburger.adapter.out.DeletarClienteAdapter;
import com.fiap.fiapburger.adapter.out.DeletarPedidoAdapter;
import com.fiap.fiapburger.application.core.usecase.DeletarClienteUseCase;
import com.fiap.fiapburger.application.core.usecase.DeletarPedidoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeletarPedidoConfig {
    @Bean
    public DeletarPedidoUseCase deletarPedidoUseCase(DeletarPedidoAdapter deletarPedidoAdapter){
        return new DeletarPedidoUseCase(deletarPedidoAdapter);
    }
}
