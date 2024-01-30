package com.fiap.fiapburger.infraestructure.api.controllers;

import com.fiap.fiapburger.core.ports.in.pagamento.WebhookPagamentoInputPort;
import com.fiap.fiapburger.infraestructure.api.mappers.PagamentoMapper;
import com.fiap.fiapburger.infraestructure.api.requests.EfetuarPagamentoRequest;
import com.fiap.fiapburger.infraestructure.api.responses.ConsultarStatusPagamentoResponse;
import com.fiap.fiapburger.infraestructure.api.responses.EfetuarPagamentoResponse;
import com.fiap.fiapburger.infraestructure.api.responses.PagamentoResponse;
import com.fiap.fiapburger.infraestructure.api.responses.WebhookPagamentoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.fiap.fiapburger.core.ports.in.pagamento.ConsultarStatusPagamentoInputPort;
import com.fiap.fiapburger.core.ports.in.pagamento.EfetuarPagamentoInputPort;
import com.fiap.fiapburger.core.ports.in.pagamento.ListarMeioPagamentoInputPort;
import java.util.List;

@Controller
@RequestMapping(value = "/pagamento", produces = MediaType.APPLICATION_JSON_VALUE)
public class PagamentoController {
    private final PagamentoMapper pagamentoMapper;
    private final ListarMeioPagamentoInputPort listarMeiosPagamentosInputPort;
    private final EfetuarPagamentoInputPort efetuarPagamentoInputPort;
    private final ConsultarStatusPagamentoInputPort consultarStatusPagamentoInputPort;
    private final WebhookPagamentoInputPort webhookPagamentoInputPort;

    @Autowired
    public PagamentoController(
            PagamentoMapper pagamentoMapper,
            ListarMeioPagamentoInputPort listarMeiosPagamentosInputPort,
            EfetuarPagamentoInputPort efetuarPagamentoInputPort,
            ConsultarStatusPagamentoInputPort consultarStatusPagamentoInputPort,
            WebhookPagamentoInputPort webhookPagamentoInputPort)
    {
        this.listarMeiosPagamentosInputPort = listarMeiosPagamentosInputPort;
        this.efetuarPagamentoInputPort = efetuarPagamentoInputPort;
        this.consultarStatusPagamentoInputPort = consultarStatusPagamentoInputPort;
        this.pagamentoMapper = pagamentoMapper;
        this.webhookPagamentoInputPort = webhookPagamentoInputPort;
    }

    @GetMapping()
    @ResponseBody
    public List<PagamentoResponse> listarMeiosPagamentos(){
        var pagamentos = listarMeiosPagamentosInputPort.listaMeio();
        return pagamentos;
    }

    @PostMapping
    public ResponseEntity<EfetuarPagamentoResponse> efetuarPagamento(@RequestBody EfetuarPagamentoRequest efetuarPagamentoRequest){

        var pagamento = pagamentoMapper.toEfetuarPagamentoResponse(efetuarPagamentoRequest);
        efetuarPagamentoInputPort.efetuarPagamento(pagamento);

        return ResponseEntity.ok(pagamento);
    };

    @GetMapping("/{id}")
    public ResponseEntity<WebhookPagamentoResponse> webhookPagamento(@PathVariable String id){
        WebhookPagamentoResponse webhookPagamento = new WebhookPagamentoResponse();
        webhookPagamento.setIdPedido(id);
        var pedido = webhookPagamentoInputPort.webhookPagamento(webhookPagamento);
        return ResponseEntity.ok(pedido);
    }

    @GetMapping("/consultar/{id}")
    public ResponseEntity<ConsultarStatusPagamentoResponse> consultarStatusPagamento(@PathVariable String id){
        ConsultarStatusPagamentoResponse consultarStatusPagamento = new ConsultarStatusPagamentoResponse();
        consultarStatusPagamento.setIdPedido(id);
        var pedido = consultarStatusPagamentoInputPort.consultarStatusPagamento(consultarStatusPagamento);
        return ResponseEntity.ok(pedido);
    }

}
