package com.fiap.fiapburger.adapter.out.cliente;

import com.fiap.fiapburger.application.core.exception.ClienteNaoEncontradoException;
import com.fiap.fiapburger.application.core.exception.ExceptionsMessageEnum;
import com.fiap.fiapburger.adapter.out.repository.ClienteRepository;
import com.fiap.fiapburger.adapter.out.repository.entity.ClienteEntity;
import com.fiap.fiapburger.adapter.out.repository.mapper.ClienteEntityMapper;
import com.fiap.fiapburger.application.core.domain.ClienteDTO;
import com.fiap.fiapburger.application.ports.out.cliente.EditarClienteOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EditarClienteAdapter implements EditarClienteOutputPort {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    ClienteEntityMapper clienteMapper;
    @Override
    public void editar(ClienteDTO cliente) {

        Optional<ClienteEntity> clienteEntity = clienteRepository.findById(cliente.getCpf());
        if(clienteEntity.isPresent()){

            clienteEntity.get().setCpf(cliente.getCpf());
            clienteEntity.get().setNome(cliente.getNome());
            clienteEntity.get().setEmail(cliente.getEmail());

            clienteRepository.save(clienteEntity.get());
        }else{

            throw new ClienteNaoEncontradoException(ExceptionsMessageEnum.CLIENTE_NAO_ENCONTRADO.value());
        }
    }
}
