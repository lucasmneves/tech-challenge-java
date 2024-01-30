package com.fiap.fiapburger.infraestructure.config.cliente;

import com.fiap.fiapburger.infraestructure.adapters.cliente.DeletarClienteAdapter;
import com.fiap.fiapburger.core.usecase.cliente.DeletarClienteUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeletarClienteConfig {
    @Bean
    public DeletarClienteUseCase deletarClienteUseCase(DeletarClienteAdapter deletarClienteAdapter){
        return new DeletarClienteUseCase(deletarClienteAdapter);
    }
}
