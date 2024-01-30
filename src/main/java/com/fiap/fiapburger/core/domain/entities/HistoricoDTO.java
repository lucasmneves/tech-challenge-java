package com.fiap.fiapburger.core.domain.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

public class HistoricoDTO implements Serializable {
    private static final long serialVersionUID = -7219867898401165547L;

    private String id;
    private String idPedido;
    private String status;
    private LocalDateTime data_hora;
    public HistoricoDTO(String id, String idPedido, String status, LocalDateTime data_hora){
        this.data_hora = data_hora;
        this.idPedido = idPedido;
        this.id = id;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getData_hora() {
        return data_hora;
    }

    public void setData_hora(LocalDateTime data_hora) {
        this.data_hora = data_hora;
    }
}
