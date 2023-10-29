package com.fiap.fiapburger.config;

import com.fiap.fiapburger.adapter.out.BuscarPedidoAdapter;
import com.fiap.fiapburger.adapter.out.ListarMeioPagamentoAdapter;
import com.fiap.fiapburger.application.core.usecase.BuscarPedidoUseCase;
import com.fiap.fiapburger.application.core.usecase.ListarMeioPagamentoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ListarMeioPagamentoConfig {

    @Bean
    public ListarMeioPagamentoUseCase listarMeioPagamentoUseCase(ListarMeioPagamentoAdapter listarMeioPagamentoAdapter){
        return new ListarMeioPagamentoUseCase(listarMeioPagamentoAdapter);
    };

}


