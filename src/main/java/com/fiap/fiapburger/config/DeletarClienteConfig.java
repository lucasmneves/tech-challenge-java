package com.fiap.fiapburger.config;

import com.fiap.fiapburger.adapter.out.DeletarClienteAdapter;
import com.fiap.fiapburger.application.core.usecase.DeletarClienteUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeletarClienteConfig {
    @Bean
    public DeletarClienteUseCase deletarClienteUseCase(DeletarClienteAdapter deletarClienteAdapter){
        return new DeletarClienteUseCase(deletarClienteAdapter);
    }
}
