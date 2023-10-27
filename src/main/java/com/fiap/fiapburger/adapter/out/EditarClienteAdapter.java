package com.fiap.fiapburger.adapter.out;

import com.fiap.fiapburger.adapter.driver.api.controller.checkout.exception.ClienteNaoEncontradoException;
import com.fiap.fiapburger.adapter.driver.api.controller.checkout.exception.ExceptionsMessageEnum;
import com.fiap.fiapburger.adapter.out.repository.ClienteRepository;
import com.fiap.fiapburger.adapter.out.repository.entity.ClienteEntity;
import com.fiap.fiapburger.adapter.out.repository.mapper.ClienteEntityMapper;
import com.fiap.fiapburger.application.core.domain.ClienteDTO;
import com.fiap.fiapburger.application.ports.out.EditarClienteOutputPort;
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

        var clienteEntity = clienteMapper.toClienteEntity(cliente);
        Optional<ClienteEntity> clienteEntityBd = clienteRepository.findById(cliente.getCpf());
        if(clienteEntityBd.isPresent()){
            clienteEntityBd.get().setCpf(clienteEntity.getCpf());
            clienteEntityBd.get().setNome(clienteEntity.getNome());
            clienteEntityBd.get().setEmail(clienteEntity.getEmail());
        }else{

            throw new ClienteNaoEncontradoException(ExceptionsMessageEnum.CLIENTE_NAO_ENCONTRADO.value());
        }
    }
}
