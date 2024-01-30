package com.fiap.fiapburger.infraestructure.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name="historico")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class HistoricoEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = -3658048184630882704L;

    @Id
    @JsonProperty("id")
    private String id;

    @JsonProperty("idPedido")
    private String idPedido;

    @JsonProperty("status")
    private String status;

    @JsonProperty("dataHora")
    private LocalDateTime dataHora;

}
