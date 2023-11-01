package com.fiap.fiapburger.config.pedido;

import com.fiap.fiapburger.adapter.out.pedido.EditarPedidoAdapter;
import com.fiap.fiapburger.application.core.usecase.pedido.EditarPedidoUseCase;
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
