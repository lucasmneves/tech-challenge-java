package com.fiap.fiapburger.adapter.driven.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fiap.fiapburger.core.domain.ClienteDTO;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteDTO, String>{

}
