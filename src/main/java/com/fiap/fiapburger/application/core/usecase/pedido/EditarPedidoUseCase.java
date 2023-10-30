package com.fiap.fiapburger.application.core.usecase.pedido;

import com.fiap.fiapburger.application.core.domain.ItensPedidoDTO;
import com.fiap.fiapburger.application.core.domain.PedidoDTO;
import com.fiap.fiapburger.application.ports.in.pedido.EditarPedidoInputPort;
import com.fiap.fiapburger.application.ports.out.pedido.EditarPedidoOutputPort;
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
}
