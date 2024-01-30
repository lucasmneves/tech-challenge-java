package com.fiap.fiapburger.core.domain.entities;

import java.io.Serializable;

public class ClienteDTO implements Serializable {

    private static final long serialVersionUID = 978370031338121183L;

    public ClienteDTO(String cpf, String email, String nome) {
        this.cpf = cpf;
        this.email = email;
        this.nome = nome;
    }

    private String cpf;
    private String email;
    private String nome;

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
