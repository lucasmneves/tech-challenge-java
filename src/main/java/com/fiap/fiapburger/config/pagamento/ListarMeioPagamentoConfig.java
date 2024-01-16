package com.fiap.fiapburger.config.pagamento;

import com.fiap.fiapburger.adapter.out.pagamento.ListarMeioPagamentoAdapter;
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
