package com.fiap.fiapburger.adapter.out.repository;

import com.fiap.fiapburger.adapter.out.repository.entity.ItensPedidoEntity;
import com.fiap.fiapburger.adapter.out.repository.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItensPedidoRepository extends JpaRepository<ItensPedidoEntity, String>{

}
