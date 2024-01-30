package com.fiap.fiapburger.infraestructure.config.produto;
import com.fiap.fiapburger.infraestructure.api.mappers.ProdutoMapper;
import com.fiap.fiapburger.infraestructure.adapters.produto.SalvarProdutoAdapter;
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