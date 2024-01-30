package com.fiap.fiapburger.infraestructure.adapters.cliente;

import com.fiap.fiapburger.infraestructure.api.mappers.ClienteMapper;
import com.fiap.fiapburger.infraestructure.api.responses.ClienteResponse;
import com.fiap.fiapburger.infraestructure.persistence.repositories.ClienteRepository;
import com.fiap.fiapburger.infraestructure.persistence.entities.ClienteEntity;
import com.fiap.fiapburger.core.domain.exception.ClienteNaoEncontradoException;
import com.fiap.fiapburger.core.domain.exception.ExceptionsMessageEnum;
import com.fiap.fiapburger.core.ports.out.cliente.BuscarClienteOutputPort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BuscarClienteAdapter implements BuscarClienteOutputPort {
    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    public BuscarClienteAdapter(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    @Override
    public ClienteResponse buscar(String cpf) {

        Optional<ClienteEntity> cliente = clienteRepository.findById(cpf);

        if(cliente.isPresent()){
            return clienteMapper.toClienteResponse(cliente.get());
        }else{
            throw new ClienteNaoEncontradoException(ExceptionsMessageEnum.CLIENTE_NAO_ENCONTRADO.value());
        }
    }
}
