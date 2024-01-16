package com.fiap.fiapburger.core.usecase.pedido;

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
    public void editar(PedidoDTO pedidoDTO, ItensPedidoDTO itensPedido) {
        editarPedidoOutputPort.editar(pedidoDTO, itensPedido);
    }

    @Override
    public void atualizarStatusPedido(PedidoDTO pedido) {
        editarPedidoOutputPort.atualizarStatusPedido(pedido);
    }
}
