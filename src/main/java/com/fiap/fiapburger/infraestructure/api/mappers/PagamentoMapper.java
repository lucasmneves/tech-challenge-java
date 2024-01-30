package com.fiap.fiapburger.infraestructure.api.mappers;

import com.fiap.fiapburger.infraestructure.api.requests.EfetuarPagamentoRequest;
import com.fiap.fiapburger.infraestructure.api.responses.EfetuarPagamentoResponse;
import com.fiap.fiapburger.infraestructure.api.responses.PagamentoResponse;
import com.fiap.fiapburger.infraestructure.persistence.entities.PagamentoEntity;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface PagamentoMapper {

    List<PagamentoResponse> toListaPagamentoResponse(List<PagamentoEntity> pagamentoEntity);
    EfetuarPagamentoResponse toEfetuarPagamentoResponse(EfetuarPagamentoRequest efetuarPagamentoRequest);
}
