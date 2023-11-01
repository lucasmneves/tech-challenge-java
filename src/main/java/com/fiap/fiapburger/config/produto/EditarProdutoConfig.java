package com.fiap.fiapburger.config.produto;

import com.fiap.fiapburger.adapter.out.produto.EditarProdutoAdapter;
import com.fiap.fiapburger.application.core.usecase.produto.EditarProdutoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EditarProdutoConfig {
    @Bean
    public EditarProdutoUseCase editarProdutoUseCase(EditarProdutoAdapter editarProdutoAdapter){
        return new EditarProdutoUseCase(editarProdutoAdapter);
    }

}
