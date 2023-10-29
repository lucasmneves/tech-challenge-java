package com.fiap.fiapburger.application.core.usecase;

import com.fiap.fiapburger.application.core.domain.ItensPedidoDTO;
import com.fiap.fiapburger.application.ports.in.DeletarClienteInputPort;
import com.fiap.fiapburger.application.ports.in.DeletarPedidoInputPort;
import com.fiap.fiapburger.application.ports.out.DeletarClienteOutputPort;
import com.fiap.fiapburger.application.ports.out.DeletarPedidoOutputPort;

import java.util.UUID;

public class DeletarPedidoUseCase implements DeletarPedidoInputPort {

    private DeletarPedidoOutputPort deletarPedidoOutputPort;

    public DeletarPedidoUseCase(DeletarPedidoOutputPort deletarPedidoOutputPort) {
        this.deletarPedidoOutputPort = deletarPedidoOutputPort;
    }

    @Override
    public void removerItens(String idProduto, String idPedido) {
        deletarPedidoOutputPort.removerItens(idProduto, idPedido);
    }

    @Override
    public void deletar(String idProduto, String idPedido) {
        deletarPedidoOutputPort.deletar(idProduto, idPedido);
    }
}
