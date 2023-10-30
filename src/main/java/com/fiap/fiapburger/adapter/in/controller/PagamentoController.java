package com.fiap.fiapburger.adapter.in.controller;

import com.fiap.fiapburger.adapter.in.controller.response.PagamentoResponse;
import com.fiap.fiapburger.application.ports.in.pagamento.ListarMeioPagamentoInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/pagamento", produces = MediaType.APPLICATION_JSON_VALUE)
public class PagamentoController {

    @Autowired
    private ListarMeioPagamentoInputPort listarMeiosPagamentosInputPort;

    @GetMapping()
    @ResponseBody
    public List<PagamentoResponse> listarMeiosPagamentos(){
        var pagamentos = listarMeiosPagamentosInputPort.listaMeio();
        return pagamentos;
    }


}
