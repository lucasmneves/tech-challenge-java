package com.fiap.fiapburger.infraestructure.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

@Entity
@Table(name="produtos")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class ProdutoCCatEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String nome;
    private String descricao;
    private String url_imagem;
    private String preco;
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

}

