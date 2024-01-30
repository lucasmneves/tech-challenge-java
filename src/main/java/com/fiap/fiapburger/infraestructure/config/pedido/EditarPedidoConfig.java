package com.fiap.fiapburger.infraestructure.config.pedido;

import com.fiap.fiapburger.infraestructure.adapters.pedido.EditarPedidoAdapter;
import com.fiap.fiapburger.core.usecase.pedido.EditarPedidoUseCase;
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

