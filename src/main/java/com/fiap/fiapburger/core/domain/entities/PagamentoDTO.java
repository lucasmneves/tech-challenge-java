package com.fiap.fiapburger.core.domain.entities;

import java.io.Serializable;

public class PagamentoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String nome;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
