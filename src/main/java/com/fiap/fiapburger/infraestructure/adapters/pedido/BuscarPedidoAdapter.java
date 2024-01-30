
package com.fiap.fiapburger.infraestructure.adapters.pedido;

import com.fiap.fiapburger.infraestructure.api.mappers.PedidoMapper;
import com.fiap.fiapburger.infraestructure.api.responses.ItensPedidoResponse;
import com.fiap.fiapburger.infraestructure.api.responses.PedidoResponse;
import com.fiap.fiapburger.infraestructure.persistence.repositories.ItensPedidoRepository;
import com.fiap.fiapburger.infraestructure.persistence.repositories.PedidoRepository;
import com.fiap.fiapburger.infraestructure.persistence.repositories.ProdutoRepository;
import com.fiap.fiapburger.infraestructure.persistence.entities.PedidoEntity;
import com.fiap.fiapburger.core.domain.entities.PedidoDTO;
import com.fiap.fiapburger.core.domain.exception.ExceptionsMessageEnum;
import com.fiap.fiapburger.core.domain.exception.PedidoNaoEncontradoException;
import com.fiap.fiapburger.core.ports.out.pedido.BuscarPedidoOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BuscarPedidoAdapter implements BuscarPedidoOutputPort {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    PedidoMapper pedidoMapper;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ItensPedidoRepository itensPedidoRepository;


    @Override
    public PedidoResponse buscar(PedidoDTO pedido) {

        PedidoResponse pedidoResponse = new PedidoResponse();
        List<ItensPedidoResponse> listItensPedidoResponse = new ArrayList<ItensPedidoResponse>();
        ItensPedidoResponse itensPedidoResponse = new ItensPedidoResponse();

        PedidoEntity pedidoEntity = pedidoRepository.findById(pedido.getId())
                .orElseThrow(() -> new PedidoNaoEncontradoException(ExceptionsMessageEnum.PEDIDO_NAO_ENCONTRADO.value()));

        pedidoResponse = pedidoMapper.toPedidoResponse(pedidoEntity);

        var itensPedido = itensPedidoRepository.buscarItensPedidoPorId(pedido.getId());

        pedidoResponse.setItensPedido(PedidoMapper.buscarItensPedidoResponse(itensPedido));

        switch (pedidoResponse.getId_status()) {
            case "1":
                pedidoResponse.setId_status(StatusPedidoEnum.PEDIDO_ABERTO.value());
                break;
            case "2":
                pedidoResponse.setId_status(StatusPedidoEnum.PEDIDO_CONFIRMADO.value());
                break;
            case "3":
                pedidoResponse.setId_status(StatusPedidoEnum.PAGAMENTO_EFETUADO.value());
                break;
            case "4":
                pedidoResponse.setId_status(StatusPedidoEnum.PEDIDO_RECEBIDO.value());
                break;
            case "5":
                pedidoResponse.setId_status(StatusPedidoEnum.PEDIDO_EM_PREPARO.value());
                break;
            case "6":
                pedidoResponse.setId_status(StatusPedidoEnum.PEDIDO_PRONTO.value());
                break;
            case "7":
                pedidoResponse.setId_status(StatusPedidoEnum.PEDIDO_ENTREGUE.value());
                break;
        }

        return pedidoResponse;

    }
}

