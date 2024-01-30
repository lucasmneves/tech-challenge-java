package com.fiap.fiapburger.infraestructure.config.cliente;

import com.fiap.fiapburger.infraestructure.adapters.cliente.BuscarClienteAdapter;
import com.fiap.fiapburger.core.usecase.cliente.BuscarClienteUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuscarClienteConfig {

    @Bean
    public BuscarClienteUseCase buscarClienteUseCase(BuscarClienteAdapter buscarClienteAdapter){
        return new BuscarClienteUseCase(buscarClienteAdapter);
    };

}


