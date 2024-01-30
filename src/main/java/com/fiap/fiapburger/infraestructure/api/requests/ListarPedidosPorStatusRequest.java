package com.fiap.fiapburger.infraestructure.api.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class ListarPedidosPorStatusRequest  implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotBlank
    @JsonProperty("id_status")
    private String id_status;

}
