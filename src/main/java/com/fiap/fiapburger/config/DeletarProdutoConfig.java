package com.fiap.fiapburger.config;

import com.fiap.fiapburger.adapter.out.DeletarProdutoAdapter;
import com.fiap.fiapburger.application.core.usecase.DeletarProdutoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeletarProdutoConfig {

    @Bean
    public DeletarProdutoUseCase deletarProdutoUseCase(DeletarProdutoAdapter deletarProdutoAdapter){
        return new DeletarProdutoUseCase(deletarProdutoAdapter);
    }

}