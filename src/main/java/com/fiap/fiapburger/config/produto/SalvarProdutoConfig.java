package com.fiap.fiapburger.config.produto;
import com.fiap.fiapburger.adapter.out.produto.SalvarProdutoAdapter;
import com.fiap.fiapburger.application.core.usecase.produto.SalvarProdutoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SalvarProdutoConfig {
    @Bean
    public SalvarProdutoUseCase salvarProdutoUseCase(SalvarProdutoAdapter salvarProdutoAdapter){
        return new SalvarProdutoUseCase(salvarProdutoAdapter);
    }

}