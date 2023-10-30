package com.fiap.fiapburger.config.cliente;

import com.fiap.fiapburger.adapter.out.cliente.EditarClienteAdapter;
import com.fiap.fiapburger.application.core.usecase.cliente.EditarClienteUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EditarClienteConfig {
    @Bean
    public EditarClienteUseCase editarClienteUseCase(EditarClienteAdapter editarClienteAdapter){
        return new EditarClienteUseCase(editarClienteAdapter);
    }
}
