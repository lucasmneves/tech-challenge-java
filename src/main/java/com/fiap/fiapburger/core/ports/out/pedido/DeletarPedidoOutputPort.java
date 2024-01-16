package com.fiap.fiapburger.core.ports.out.pedido;

public interface DeletarPedidoOutputPort {
    void deletar(String idProduto, String idPedidos);
    void removerItens(String idProduto, String idPedidos);
}
