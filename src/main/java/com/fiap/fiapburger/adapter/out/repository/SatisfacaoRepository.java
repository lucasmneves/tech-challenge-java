package com.fiap.fiapburger.adapter.out.repository;

import com.fiap.fiapburger.adapter.out.repository.entity.SatisfacaoEntity;
import com.fiap.fiapburger.adapter.out.repository.entity.StatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SatisfacaoRepository extends JpaRepository<SatisfacaoEntity, String>{
}
