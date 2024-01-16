package com.fiap.fiapburger.config.produto;



import com.fiap.fiapburger.adapter.out.produto.DeletarProdutoAdapter;
import com.fiap.fiapburger.core.usecase.produto.DeletarProdutoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeletarProdutoConfig {

    @Bean
    public DeletarProdutoUseCase deletarProdutoUseCase(DeletarProdutoAdapter deletarProdutoAdapter){
        return new DeletarProdutoUseCase(deletarProdutoAdapter);
    }

}