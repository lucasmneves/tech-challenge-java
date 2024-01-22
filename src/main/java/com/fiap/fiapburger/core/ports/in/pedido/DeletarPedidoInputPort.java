package com.fiap.fiapburger.core.ports.in.pedido;

import com.fiap.fiapburger.adapter.in.controller.request.RemoverItensPedidoRequest;

public interface DeletarPedidoInputPort {
    void deletar(RemoverItensPedidoRequest itensPedidoRequest);
    void removerItens(String idProduto, String idPedidos);
}
