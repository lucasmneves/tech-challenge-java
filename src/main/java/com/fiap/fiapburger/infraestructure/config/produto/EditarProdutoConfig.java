package com.fiap.fiapburger.infraestructure.config.produto;

import com.fiap.fiapburger.infraestructure.api.mappers.ProdutoMapper;
import com.fiap.fiapburger.infraestructure.adapters.produto.EditarProdutoAdapter;
import com.fiap.fiapburger.core.usecase.produto.EditarProdutoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EditarProdutoConfig {
    @Bean
    public EditarProdutoUseCase editarProdutoUseCase(EditarProdutoAdapter editarProdutoAdapter, ProdutoMapper produtoMapper){
        return new EditarProdutoUseCase(editarProdutoAdapter, produtoMapper);
    }

}
