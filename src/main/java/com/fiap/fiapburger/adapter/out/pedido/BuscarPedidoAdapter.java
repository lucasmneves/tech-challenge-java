
package com.fiap.fiapburger.adapter.out.pedido;

import com.fiap.fiapburger.adapter.in.controller.mapper.PedidoMapper;
import com.fiap.fiapburger.adapter.in.controller.response.ItensPedidoResponse;
import com.fiap.fiapburger.adapter.in.controller.response.PedidoResponse;
import com.fiap.fiapburger.adapter.out.repository.ItensPedidoRepository;
import com.fiap.fiapburger.adapter.out.repository.PedidoRepository;
import com.fiap.fiapburger.adapter.out.repository.ProdutoRepository;
import com.fiap.fiapburger.adapter.out.repository.entity.PedidoEntity;
import com.fiap.fiapburger.application.core.domain.PedidoDTO;
import com.fiap.fiapburger.application.core.exception.ExceptionsMessageEnum;
import com.fiap.fiapburger.application.core.exception.PedidoNaoEncontradoException;
import com.fiap.fiapburger.application.ports.out.pedido.BuscarPedidoOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BuscarPedidoAdapter implements BuscarPedidoOutputPort {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    PedidoMapper pedidoMapper;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ItensPedidoRepository itensPedidoRepository;


    @Override
    public PedidoResponse buscar(PedidoDTO pedido) {

        PedidoResponse pedidoResponse = new PedidoResponse();
        List<ItensPedidoResponse> listItensPedidoResponse = new ArrayList<ItensPedidoResponse>();
        ItensPedidoResponse itensPedidoResponse = new ItensPedidoResponse();

        PedidoEntity pedidoEntity = pedidoRepository.findById(pedido.getId())
                .orElseThrow(() -> new PedidoNaoEncontradoException(ExceptionsMessageEnum.PEDIDO_NAO_ENCONTRADO.value()));

        pedidoResponse = pedidoMapper.toPedidoResponse(pedidoEntity);

        var itensPedido = itensPedidoRepository.buscarItensPedidoPorId(pedido.getId());

        pedidoResponse.setItensPedido(PedidoMapper.buscarItensPedidoResponse(itensPedido));

        return pedidoResponse;

    }
}

