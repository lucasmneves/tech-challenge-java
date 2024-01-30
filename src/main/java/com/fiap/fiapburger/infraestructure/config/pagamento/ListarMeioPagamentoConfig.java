package com.fiap.fiapburger.infraestructure.config.pagamento;

import com.fiap.fiapburger.infraestructure.adapters.pagamento.ListarMeioPagamentoAdapter;
import com.fiap.fiapburger.core.usecase.pagamento.ListarMeioPagamentoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ListarMeioPagamentoConfig {

    @Bean
    public ListarMeioPagamentoUseCase listarMeioPagamentoUseCase(ListarMeioPagamentoAdapter listarMeioPagamentoAdapter){
        return new ListarMeioPagamentoUseCase(listarMeioPagamentoAdapter);
    };

}
