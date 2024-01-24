package com.fiap.fiapburger.config.produto;
import com.fiap.fiapburger.adapter.in.controller.mapper.ProdutoMapper;
import com.fiap.fiapburger.adapter.out.produto.SalvarProdutoAdapter;
import com.fiap.fiapburger.core.usecase.produto.SalvarProdutoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SalvarProdutoConfig {
    @Bean
    public SalvarProdutoUseCase salvarProdutoUseCase(SalvarProdutoAdapter salvarProdutoAdapter, ProdutoMapper produtoMapper){
        return new SalvarProdutoUseCase(salvarProdutoAdapter, produtoMapper);
    }

}