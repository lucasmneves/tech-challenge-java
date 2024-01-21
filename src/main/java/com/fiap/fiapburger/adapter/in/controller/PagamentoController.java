package com.fiap.fiapburger.adapter.in.controller;

import com.fiap.fiapburger.adapter.in.controller.mapper.PagamentoMapper;
import com.fiap.fiapburger.adapter.in.controller.request.EfetuarPagamentoRequest;
import com.fiap.fiapburger.adapter.in.controller.response.ConsultarStatusPagamentoResponse;
import com.fiap.fiapburger.adapter.in.controller.response.EfetuarPagamentoResponse;
import com.fiap.fiapburger.adapter.in.controller.response.PagamentoResponse;
import com.fiap.fiapburger.core.ports.in.pagamento.ConsultarStatusPagamentoInputPort;
import com.fiap.fiapburger.core.ports.in.pagamento.EfetuarPagamentoInputPort;
import com.fiap.fiapburger.core.ports.in.pagamento.ListarMeioPagamentoInputPort;
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

    @Autowired
    private EfetuarPagamentoInputPort efetuarPagamentoInputPort;

    @Autowired
    private ConsultarStatusPagamentoInputPort consultarStatusPagamentoInputPort;

    @GetMapping()
    @ResponseBody
    public List<PagamentoResponse> listarMeiosPagamentos(){
        return listarMeiosPagamentosInputPort.listaMeio();
    }

    @PostMapping
    public ResponseEntity<EfetuarPagamentoResponse> efetuarPagamento(@RequestBody EfetuarPagamentoRequest efetuarPagamentoRequest){

        var pagamento = efetuarPagamentoInputPort.efetuarPagamento(efetuarPagamentoRequest);
        return ResponseEntity.ok(pagamento);
    };

    @GetMapping("/{id}")
    public ResponseEntity<ConsultarStatusPagamentoResponse> consultaStatusPagamento(@PathVariable String id){

        var statusPagamento = consultarStatusPagamentoInputPort.consultarStatusPagamento(id);
        return ResponseEntity.ok(statusPagamento);
    }


}
