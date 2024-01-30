package com.fiap.fiapburger.infraestructure.persistence.mapper;

import com.fiap.fiapburger.infraestructure.api.requests.HistoricoRequest;
import com.fiap.fiapburger.infraestructure.persistence.entities.HistoricoEntity;
import com.fiap.fiapburger.core.domain.entities.HistoricoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HistoricoMapper {
    HistoricoEntity toHistoricoEntity(HistoricoDTO historicoDTO);
    HistoricoDTO toHistoricoDTO (HistoricoRequest historicoRequest);
}
