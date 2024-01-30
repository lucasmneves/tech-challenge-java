package com.fiap.fiapburger.infraestructure.config.produto;


import com.fiap.fiapburger.infraestructure.adapters.produto.BuscarTodosProdutosAdapter;
import com.fiap.fiapburger.core.usecase.produto.BuscarTodosProdutosUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuscarTodosProdutosConfig {
    @Bean
    public BuscarTodosProdutosUseCase buscarTodosProdutosUseCase(BuscarTodosProdutosAdapter buscarTodosProdutoAdapter){
        return new BuscarTodosProdutosUseCase(buscarTodosProdutoAdapter);
    }
}
