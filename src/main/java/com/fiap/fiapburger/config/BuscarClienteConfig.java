package com.fiap.fiapburger.config;

import com.fiap.fiapburger.adapter.out.BuscarClienteAdapter;
import com.fiap.fiapburger.application.core.usecase.BuscarClienteUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuscarClienteConfig {

    @Bean
    public BuscarClienteUseCase buscarClienteUseCase(BuscarClienteAdapter buscarClienteAdapter){
        return new BuscarClienteUseCase(buscarClienteAdapter);
    };

}


