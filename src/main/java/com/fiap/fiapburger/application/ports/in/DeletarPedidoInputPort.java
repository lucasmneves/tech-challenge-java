package com.fiap.fiapburger.application.ports.in;

public interface DeletarPedidoInputPort {
    void deletar(String idProduto, String idPedido);
    void removerItens(String idProduto, String idPedidos);
}
