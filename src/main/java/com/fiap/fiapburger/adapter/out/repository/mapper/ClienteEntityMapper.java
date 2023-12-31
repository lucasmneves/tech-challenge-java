package com.fiap.fiapburger.adapter.out.repository.mapper;

import com.fiap.fiapburger.adapter.out.repository.entity.ClienteEntity;
import com.fiap.fiapburger.application.core.domain.ClienteDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ClienteEntityMapper {
    ClienteEntity toClienteEntity(ClienteDTO cliente);
}
