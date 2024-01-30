package com.fiap.fiapburger.infraestructure.adapters.cliente;

import com.fiap.fiapburger.infraestructure.persistence.repositories.ClienteRepository;
import com.fiap.fiapburger.infraestructure.persistence.mapper.ClienteEntityMapper;
import com.fiap.fiapburger.core.domain.entities.ClienteDTO;
import com.fiap.fiapburger.core.ports.out.cliente.SalvarClienteOutputPort;

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
