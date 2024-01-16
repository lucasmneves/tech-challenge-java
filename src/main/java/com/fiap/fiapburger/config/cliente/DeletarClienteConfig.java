package com.fiap.fiapburger.config.cliente;

import com.fiap.fiapburger.adapter.out.cliente.DeletarClienteAdapter;
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
