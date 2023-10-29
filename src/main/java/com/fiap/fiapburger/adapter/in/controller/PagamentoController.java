package com.fiap.fiapburger.adapter.in.controller;

import com.fiap.fiapburger.adapter.in.controller.response.PagamentoResponse;
import com.fiap.fiapburger.adapter.in.controller.response.PedidoResponse;
import com.fiap.fiapburger.application.ports.in.DeletarPedidoInputPort;
import com.fiap.fiapburger.application.ports.in.ListarMeioPagamentoInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping(value = "/pagamento", produces = MediaType.APPLICATION_JSON_VALUE)
public class PagamentoController {

    @Autowired
    private ListarMeioPagamentoInputPort listarMeiosPagamentosInputPort;

    @GetMapping()
    public ResponseEntity<PagamentoResponse> listarMeiosPagamentos(){
        var pagamentos = listarMeiosPagamentosInputPort.listaMeio();
        return ResponseEntity.ok(pagamentos);
    }


}
