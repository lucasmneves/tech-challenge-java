package com.fiap.fiapburger.core.domain.entities;

import java.io.Serializable;

public class StatusDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String descricao;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
