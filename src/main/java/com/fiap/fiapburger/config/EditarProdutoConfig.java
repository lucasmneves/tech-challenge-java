package com.fiap.fiapburger.config;

import com.fiap.fiapburger.adapter.out.EditarProdutoAdapter;
import com.fiap.fiapburger.application.core.usecase.EditarProdutoUseCase;
import com.fiap.fiapburger.application.ports.in.EditarProdutoInputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EditarProdutoConfig {

    @Bean
    public EditarProdutoInputPort editarProdutoInputPort(EditarProdutoAdapter editarProdutoAdapter){
        return new EditarProdutoUseCase(editarProdutoAdapter);
    }

}