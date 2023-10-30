
package com.fiap.fiapburger.config.pedido;

import com.fiap.fiapburger.adapter.out.cliente.BuscarClienteAdapter;
import com.fiap.fiapburger.adapter.out.pedido.BuscarPedidoAdapter;
import com.fiap.fiapburger.application.core.usecase.cliente.BuscarClienteUseCase;
import com.fiap.fiapburger.application.core.usecase.pedido.BuscarPedidoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuscarPedidoConfig {

    @Bean
    public BuscarPedidoUseCase buscarPedidoUseCase(BuscarPedidoAdapter buscarPedidoAdapter){
        return new BuscarPedidoUseCase(buscarPedidoAdapter);
    };

}
