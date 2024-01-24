package com.fiap.fiapburger.adapter.out.pedido;

import com.fiap.fiapburger.adapter.in.controller.mapper.PedidoMapper;
import com.fiap.fiapburger.adapter.in.controller.response.PedidoResponse;
import com.fiap.fiapburger.adapter.out.repository.PedidoRepository;
import com.fiap.fiapburger.adapter.out.repository.entity.PedidoEntity;
import com.fiap.fiapburger.core.ports.out.pedido.ListarPedidosOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ListarPedidosAdapter implements ListarPedidosOutputPort {

    private final PedidoRepository pedidoRepository;
    private final PedidoMapper pedidosMapper;

    public ListarPedidosAdapter(PedidoRepository pedidoRepository, PedidoMapper pedidosMapper) {
        this.pedidoRepository = pedidoRepository;
        this.pedidosMapper = pedidosMapper;
    }

    @Override
    public List<PedidoResponse> listaPedidos() {
        return pedidoRepository.findAll().stream()
                .sorted((p1,p2)->p1.getData_hora_inicio().compareTo(p2.getData_hora_inicio()))
                .map(pedidosMapper::toPedidoResponse)
                .collect(Collectors.toList());
    }
    @Override
    public List<PedidoResponse> listaPedidosPorStatus(String id_status) {
        return pedidoRepository.findAll().stream()
                .filter(pedidoEntity -> pedidoEntity.getId_status().equals(id_status))
                .map(pedidosMapper::toPedidoResponse)
                .collect(Collectors.toList());
    }
}
