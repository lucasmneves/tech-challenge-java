package com.fiap.fiapburger.adapter.out;

import com.fiap.fiapburger.adapter.out.repository.mapper.ClienteEntityMapper;
import com.fiap.fiapburger.application.core.domain.ClienteDTO;
import com.fiap.fiapburger.application.ports.out.SalvarClienteOutputPort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class SalvarClienteAdapter implements SalvarClienteOutputPort {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteEntityMapper clienteEntityMapper;
    @Override
    public void salvar(ClienteDTO cliente) {

        var clienteEntity = clienteEntityMapper.toClienteEntity(cliente);
        clienteRepository.save(clienteEntity);
    }
}
