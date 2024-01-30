package com.fiap.fiapburger.infraestructure.api.mappers;

import com.fiap.fiapburger.infraestructure.api.requests.ClienteRequest;
import com.fiap.fiapburger.infraestructure.api.responses.ClienteResponse;
import com.fiap.fiapburger.infraestructure.persistence.entities.ClienteEntity;
import com.fiap.fiapburger.core.domain.entities.ClienteDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ClienteMapper {
    ClienteDTO toCliente(ClienteRequest clienteRequest);
    ClienteResponse toClienteResponse(ClienteEntity clienteEntity);
}
