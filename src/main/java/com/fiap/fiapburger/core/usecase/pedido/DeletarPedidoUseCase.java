package com.fiap.fiapburger.core.usecase.pedido;

import com.fiap.fiapburger.infraestructure.api.requests.RemoverItensPedidoRequest;
import com.fiap.fiapburger.core.ports.in.pedido.DeletarPedidoInputPort;
import com.fiap.fiapburger.core.ports.out.pedido.DeletarPedidoOutputPort;

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
    public void deletar(RemoverItensPedidoRequest itensPedidoRequest) {

        //ItensPedidoDTO itensPedido = PedidoMapper.removerItensPedido(itensPedidoRequest);
        this.removerItens(itensPedidoRequest.getIdProduto(), itensPedidoRequest.getIdPedido());
        deletarPedidoOutputPort.deletar(itensPedidoRequest.getIdProduto(), itensPedidoRequest.getIdPedido());
    }
}
