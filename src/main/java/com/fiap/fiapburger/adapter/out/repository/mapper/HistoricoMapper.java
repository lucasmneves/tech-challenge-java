package com.fiap.fiapburger.adapter.out.repository.mapper;

import com.fiap.fiapburger.adapter.in.controller.request.HistoricoRequest;
import com.fiap.fiapburger.adapter.out.repository.entity.HistoricoEntity;
import com.fiap.fiapburger.application.core.domain.HistoricoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HistoricoMapper {
    HistoricoEntity toHistoricoEntity(HistoricoDTO historicoDTO);
    HistoricoDTO toHistoricoDTO (HistoricoRequest historicoRequest);
}
