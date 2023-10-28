package com.fiap.fiapburger.config;

import com.fiap.fiapburger.adapter.out.EditarPedidoAdapter;
import com.fiap.fiapburger.adapter.out.SalvarPedidoAdapter;
import com.fiap.fiapburger.application.core.usecase.EditarPedidoUseCase;
import com.fiap.fiapburger.application.core.usecase.SalvarPedidoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EditarPedidoConfig {
    @Bean
    public EditarPedidoUseCase editarPedidoUseCase(EditarPedidoAdapter editarPedidoAdapter)
    {
        return new EditarPedidoUseCase(editarPedidoAdapter);
    }
}
