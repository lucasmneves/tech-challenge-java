package com.fiap.fiapburger.adapter.out.repository;

import com.fiap.fiapburger.adapter.out.repository.entity.PagamentoEntity;
import com.fiap.fiapburger.adapter.out.repository.entity.SatisfacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<PagamentoEntity, String>{
}
