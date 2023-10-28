package com.fiap.fiapburger.application.core.usecase;

import com.fiap.fiapburger.application.core.domain.ItensPedidoDTO;
import com.fiap.fiapburger.application.core.domain.PedidoDTO;
import com.fiap.fiapburger.application.ports.in.EditarPedidoInputPort;
import com.fiap.fiapburger.application.ports.in.SalvarPedidoInputPort;
import com.fiap.fiapburger.application.ports.out.EditarPedidoOutputPort;
import com.fiap.fiapburger.application.ports.out.SalvarPedidoOutputPort;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class EditarPedidoUseCase implements EditarPedidoInputPort {

    private final EditarPedidoOutputPort editarPedidoOutputPort;

    public EditarPedidoUseCase(EditarPedidoOutputPort editarPedidoOutputPort) {
        this.editarPedidoOutputPort = editarPedidoOutputPort;
    }
    @Override
    public void editar(ItensPedidoDTO itensPedidoDTO) {

        UUID id = UUID.randomUUID();
        itensPedidoDTO.setId(id.toString());

        editarPedidoOutputPort.editar(itensPedidoDTO);
    }
}
