package com.fiap.fiapburger.infraestructure.adapters.cliente;

import com.fiap.fiapburger.core.domain.exception.ClienteNaoEncontradoException;
import com.fiap.fiapburger.core.domain.exception.ExceptionsMessageEnum;
import com.fiap.fiapburger.infraestructure.persistence.repositories.ClienteRepository;
import com.fiap.fiapburger.core.ports.out.cliente.DeletarClienteOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeletarClienteAdapter implements DeletarClienteOutputPort {

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public void deletar(String cpf) {
        var cliente = clienteRepository.findById(cpf);
        if(cliente.isPresent()){
            clienteRepository.deleteById(cpf);
        }else{
            throw new ClienteNaoEncontradoException(ExceptionsMessageEnum.CLIENTE_NAO_ENCONTRADO.value());
        }
    }
}
