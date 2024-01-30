package com.fiap.fiapburger.infraestructure.persistence.repositories;

import com.fiap.fiapburger.infraestructure.persistence.entities.SatisfacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SatisfacaoRepository extends JpaRepository<SatisfacaoEntity, String>{
}
