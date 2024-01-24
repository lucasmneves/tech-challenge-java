package com.fiap.fiapburger.config.cliente;

import com.fiap.fiapburger.adapter.in.controller.mapper.ClienteMapper;
import com.fiap.fiapburger.adapter.out.cliente.EditarClienteAdapter;
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
