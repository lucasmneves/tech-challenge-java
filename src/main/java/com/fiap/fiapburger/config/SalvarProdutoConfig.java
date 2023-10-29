package com.fiap.fiapburger.config;

import com.fiap.fiapburger.adapter.out.SalvarProdutoAdapter;
import com.fiap.fiapburger.application.core.usecase.SalvarProdutoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SalvarProdutoConfig {

    @Bean
    public SalvarProdutoUseCase salvarProdutoUseCase(SalvarProdutoAdapter salvarProdutoAdapter){
        return new SalvarProdutoUseCase(salvarProdutoAdapter);
    }

}