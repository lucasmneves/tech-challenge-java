package com.fiap.fiapburger.config.cliente;

import com.fiap.fiapburger.adapter.out.cliente.BuscarClienteAdapter;
import com.fiap.fiapburger.application.core.usecase.cliente.BuscarClienteUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuscarClienteConfig {

    @Bean
    public BuscarClienteUseCase buscarClienteUseCase(BuscarClienteAdapter buscarClienteAdapter){
        return new BuscarClienteUseCase(buscarClienteAdapter);
    };

}


