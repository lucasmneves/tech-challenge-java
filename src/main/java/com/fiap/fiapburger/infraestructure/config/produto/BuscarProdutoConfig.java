package com.fiap.fiapburger.infraestructure.config.produto;



import com.fiap.fiapburger.infraestructure.adapters.produto.BuscarProdutoAdapter;
import com.fiap.fiapburger.core.usecase.produto.BuscarProdutoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuscarProdutoConfig {

    @Bean
    public BuscarProdutoUseCase buscarProdutoUseCase(BuscarProdutoAdapter buscarProdutoAdapter){
        return new BuscarProdutoUseCase(buscarProdutoAdapter);
    }

}
