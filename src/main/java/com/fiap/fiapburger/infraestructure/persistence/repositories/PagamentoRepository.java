package com.fiap.fiapburger.infraestructure.persistence.repositories;

import com.fiap.fiapburger.infraestructure.persistence.entities.PagamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<PagamentoEntity, String>{
}
