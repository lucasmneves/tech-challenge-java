package com.fiap.fiapburger.adapter.out.pedido;

import com.fiap.fiapburger.adapter.in.controller.mapper.PedidoMapper;
import com.fiap.fiapburger.adapter.in.controller.response.PedidoResponse;
import com.fiap.fiapburger.adapter.out.repository.PedidoRepository;
import com.fiap.fiapburger.core.ports.out.pedido.ListarPedidosOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ListarPedidosAdapter implements ListarPedidosOutputPort {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PedidoMapper pedidosMapper;
    @Override
    public List<PedidoResponse> listaPedidos() {
        return pedidoRepository.findAll().stream()
                .map(pedidoEntity -> pedidosMapper.toPedidoResponse(pedidoEntity))
                .collect(Collectors.toList());
    }
    @Override
    public List<PedidoResponse> listaPedidosPorStatus(String id_status) {
        return pedidoRepository.findAll().stream()
                .filter(pedidoEntity -> pedidoEntity.getId_status().equals(id_status))
                .map(pedidoEntity -> pedidosMapper.toPedidoResponse(pedidoEntity))
                .collect(Collectors.toList());
    }
}
