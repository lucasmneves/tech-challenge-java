package com.fiap.fiapburger.adapter.in.controller.mapper;

import com.fiap.fiapburger.adapter.in.controller.request.AdicionarItensPedidoRequest;
import com.fiap.fiapburger.adapter.in.controller.request.RemoverItensPedidoRequest;
import com.fiap.fiapburger.adapter.in.controller.request.SalvarPedidoRequest;
import com.fiap.fiapburger.adapter.in.controller.response.PagamentoResponse;
import com.fiap.fiapburger.adapter.in.controller.response.PedidoResponse;
import com.fiap.fiapburger.adapter.out.repository.entity.PagamentoEntity;
import com.fiap.fiapburger.adapter.out.repository.entity.PedidoEntity;
import com.fiap.fiapburger.application.core.domain.ItensPedidoDTO;
import com.fiap.fiapburger.application.core.domain.PedidoDTO;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;


@Mapper(componentModel = "spring")
public interface PagamentoMapper {

    List<PagamentoResponse> toListaPagamentoResponse(List<PagamentoEntity> pagamentoEntity);

}
