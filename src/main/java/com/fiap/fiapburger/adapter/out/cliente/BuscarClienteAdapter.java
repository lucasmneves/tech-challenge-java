package com.fiap.fiapburger.adapter.out.cliente;

import com.fiap.fiapburger.adapter.in.controller.mapper.ClienteMapper;
import com.fiap.fiapburger.adapter.in.controller.response.ClienteResponse;
import com.fiap.fiapburger.adapter.out.repository.ClienteRepository;
import com.fiap.fiapburger.adapter.out.repository.entity.ClienteEntity;
import com.fiap.fiapburger.core.domain.exception.ClienteNaoEncontradoException;
import com.fiap.fiapburger.core.domain.exception.ExceptionsMessageEnum;
import com.fiap.fiapburger.core.ports.out.cliente.BuscarClienteOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BuscarClienteAdapter implements BuscarClienteOutputPort {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    ClienteMapper clienteMapper;

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
