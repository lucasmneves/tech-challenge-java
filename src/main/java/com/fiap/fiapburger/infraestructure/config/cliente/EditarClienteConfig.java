package com.fiap.fiapburger.infraestructure.config.cliente;

import com.fiap.fiapburger.infraestructure.api.mappers.ClienteMapper;
import com.fiap.fiapburger.infraestructure.adapters.cliente.EditarClienteAdapter;
import com.fiap.fiapburger.core.usecase.cliente.EditarClienteUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EditarClienteConfig {
    @Bean
    public EditarClienteUseCase editarClienteUseCase(EditarClienteAdapter editarClienteAdapter, ClienteMapper clienteMapper){
        return new EditarClienteUseCase(editarClienteAdapter, clienteMapper);
    }
}
