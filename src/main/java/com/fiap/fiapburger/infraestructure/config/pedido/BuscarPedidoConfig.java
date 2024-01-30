
package com.fiap.fiapburger.infraestructure.config.pedido;

import com.fiap.fiapburger.infraestructure.adapters.pedido.BuscarPedidoAdapter;
import com.fiap.fiapburger.core.usecase.pedido.BuscarPedidoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuscarPedidoConfig {

    @Bean
    public BuscarPedidoUseCase buscarPedidoUseCase(BuscarPedidoAdapter buscarPedidoAdapter){
        return new BuscarPedidoUseCase(buscarPedidoAdapter);
    };

}
