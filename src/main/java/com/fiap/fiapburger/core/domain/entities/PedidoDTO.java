package com.fiap.fiapburger.core.domain.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class PedidoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private Integer senha;
    private String id_status;
    private String cpf;
    private String detalhes;
    private BigDecimal valor_total;
    private Date data_hora_inicio;
    private Date data_hora_fim;
    private String id_pagamento;
    private String id_satisfacao;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getSenha() {
        return senha;
    }

    public void setSenha(Integer senha) {
        this.senha = senha;
    }

    public String getId_status() {
        return id_status;
    }

    public void setId_status(String id_status) {
        this.id_status = id_status;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    public BigDecimal getValor_total() {
        return valor_total;
    }

    public void setValor_total(BigDecimal valor_total) {
        this.valor_total = valor_total;
    }

    public Date getData_hora_inicio() {
        return data_hora_inicio;
    }

    public void setData_hora_inicio(Date data_hora_inicio) {
        this.data_hora_inicio = data_hora_inicio;
    }

    public Date getData_hora_fim() {
        return data_hora_fim;
    }

    public void setData_hora_fim(Date data_hora_fim) {
        this.data_hora_fim = data_hora_fim;
    }

    public String getId_pagamento() {
        return id_pagamento;
    }

    public void setId_pagamento(String id_pagamento) {
        this.id_pagamento = id_pagamento;
    }

    public String getId_satisfacao() {
        return id_satisfacao;
    }

    public void setId_satisfacao(String id_satisfacao) {
        this.id_satisfacao = id_satisfacao;
    }
}
