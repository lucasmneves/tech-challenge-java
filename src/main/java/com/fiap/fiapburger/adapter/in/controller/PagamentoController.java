package com.fiap.fiapburger.adapter.in.controller;

import com.fiap.fiapburger.adapter.in.controller.mapper.PagamentoMapper;
import com.fiap.fiapburger.adapter.in.controller.request.EfetuarPagamentoRequest;
import com.fiap.fiapburger.adapter.in.controller.response.ConsultarStatusPagamentoResponse;
import com.fiap.fiapburger.adapter.in.controller.response.EfetuarPagamentoResponse;
import com.fiap.fiapburger.adapter.in.controller.response.PagamentoResponse;
import com.fiap.fiapburger.adapter.in.controller.response.PedidoResponse;
import com.fiap.fiapburger.application.core.domain.PedidoDTO;
import com.fiap.fiapburger.application.ports.in.pagamento.ConsultarStatusPagamentoInputPort;
import com.fiap.fiapburger.application.ports.in.pagamento.EfetuarPagamentoInputPort;
import com.fiap.fiapburger.application.ports.in.pagamento.ListarMeioPagamentoInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

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

    @Autowired
    private PagamentoMapper pagamentoMapper;

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
    public ResponseEntity<ConsultarStatusPagamentoResponse> consultaStatusPagamento(@PathVariable String id){
        ConsultarStatusPagamentoResponse statusPagamento = new ConsultarStatusPagamentoResponse();
        statusPagamento.setIdPedido(id);
        var pedido = consultarStatusPagamentoInputPort.consultarStatusPagamento(statusPagamento);
        return ResponseEntity.ok(pedido);
    }


}
