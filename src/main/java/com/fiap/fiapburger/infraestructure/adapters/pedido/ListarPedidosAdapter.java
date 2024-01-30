package com.fiap.fiapburger.infraestructure.adapters.pedido;

import com.fiap.fiapburger.infraestructure.api.mappers.PedidoMapper;
import com.fiap.fiapburger.infraestructure.api.responses.PedidoResponse;
import com.fiap.fiapburger.infraestructure.persistence.repositories.PedidoRepository;
import com.fiap.fiapburger.core.ports.out.pedido.ListarPedidosOutputPort;
import com.fiap.fiapburger.infraestructure.persistence.entities.PedidoEntity;
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
                .filter(p -> (!p.getId_status().equals("7")))
                .sorted(Comparator.comparing(PedidoEntity::getId_status)
                        .reversed()
                        .thenComparing(PedidoEntity::getData_hora_inicio))
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
