package com.fiap.fiapburger.core.usecase.pedido;

import com.fiap.fiapburger.infraestructure.api.mappers.PedidoMapper;
import com.fiap.fiapburger.infraestructure.api.requests.AdicionarItensPedidoRequest;
import com.fiap.fiapburger.core.domain.entities.ItensPedidoDTO;
import com.fiap.fiapburger.core.domain.entities.PedidoDTO;
import com.fiap.fiapburger.core.ports.in.pedido.EditarPedidoInputPort;
import com.fiap.fiapburger.core.ports.out.pedido.EditarPedidoOutputPort;
import java.util.UUID;

public class EditarPedidoUseCase implements EditarPedidoInputPort {

    private final EditarPedidoOutputPort editarPedidoOutputPort;

    public EditarPedidoUseCase(EditarPedidoOutputPort editarPedidoOutputPort) {
        this.editarPedidoOutputPort = editarPedidoOutputPort;
    }
    @Override
    public void adicionarItens(ItensPedidoDTO itensPedidoDTO) {

        UUID id = UUID.randomUUID();
        itensPedidoDTO.setId(id.toString());

        editarPedidoOutputPort.adicionarItens(itensPedidoDTO);
    }

    @Override
    public void editar(AdicionarItensPedidoRequest itensPedidoRequest) {
        ItensPedidoDTO itensPedido = PedidoMapper.adicionarItensPedido(itensPedidoRequest);
        PedidoDTO pedido = PedidoMapper.editar(itensPedidoRequest);
        this.adicionarItens(itensPedido);
        editarPedidoOutputPort.editar(pedido, itensPedido);
    }

    @Override
    public void atualizarStatusPedido(PedidoDTO pedido) {
        editarPedidoOutputPort.atualizarStatusPedido(pedido);
    }
}
