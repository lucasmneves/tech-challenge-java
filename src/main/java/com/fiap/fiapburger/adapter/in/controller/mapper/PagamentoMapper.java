package com.fiap.fiapburger.adapter.in.controller.mapper;

import com.fiap.fiapburger.adapter.in.controller.request.EfetuarPagamentoRequest;
import com.fiap.fiapburger.adapter.in.controller.response.EfetuarPagamentoResponse;
import com.fiap.fiapburger.adapter.in.controller.response.PagamentoResponse;
import com.fiap.fiapburger.adapter.out.repository.entity.PagamentoEntity;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface PagamentoMapper {

    List<PagamentoResponse> toListaPagamentoResponse(List<PagamentoEntity> pagamentoEntity);
    EfetuarPagamentoResponse toEfetuarPagamentoResponse(EfetuarPagamentoRequest efetuarPagamentoRequest);
}
