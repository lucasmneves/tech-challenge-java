package com.fiap.fiapburger.adapter.in.controller.mapper;

import com.fiap.fiapburger.adapter.in.controller.request.ClienteRequest;
import com.fiap.fiapburger.adapter.in.controller.response.ClienteResponse;
import com.fiap.fiapburger.adapter.out.repository.entity.ClienteEntity;
import com.fiap.fiapburger.application.core.domain.ClienteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface ClienteMapper {

    ClienteDTO toCliente(ClienteRequest clienteRequest);
    ClienteResponse toClienteResponse(ClienteEntity clienteEntity);
}
