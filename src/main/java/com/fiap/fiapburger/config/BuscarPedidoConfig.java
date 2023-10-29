package com.fiap.fiapburger.config;

import com.fiap.fiapburger.adapter.out.BuscarClienteAdapter;
import com.fiap.fiapburger.adapter.out.BuscarPedidoAdapter;
import com.fiap.fiapburger.application.core.usecase.BuscarClienteUseCase;
import com.fiap.fiapburger.application.core.usecase.BuscarPedidoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuscarPedidoConfig {

    @Bean
    public BuscarPedidoUseCase buscarPedidoUseCase(BuscarPedidoAdapter buscarPedidoAdapter){
        return new BuscarPedidoUseCase(buscarPedidoAdapter);
    };

}


