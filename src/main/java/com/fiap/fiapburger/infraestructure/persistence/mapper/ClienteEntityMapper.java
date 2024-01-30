package com.fiap.fiapburger.infraestructure.persistence.mapper;

import com.fiap.fiapburger.infraestructure.persistence.entities.ClienteEntity;
import com.fiap.fiapburger.core.domain.entities.ClienteDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ClienteEntityMapper {
    ClienteEntity toClienteEntity(ClienteDTO cliente);
}
