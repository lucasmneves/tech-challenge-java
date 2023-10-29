package com.fiap.fiapburger.adapter.out.repository;

import com.fiap.fiapburger.adapter.out.repository.entity.ItensPedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItensPedidoRepository extends JpaRepository<ItensPedidoEntity, String>{
    //@Query("FROM itens_pedido ip WHERE ip.id_produto = :id_produto AND ip.id_pedido = :id_pedido")
    //Optional<ItensPedidoEntity> findByIdProdutoAndIdPedido(String id_produto, String id_pedido);


}
