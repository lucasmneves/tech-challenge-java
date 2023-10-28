package com.fiap.fiapburger.adapter.out;

import com.fiap.fiapburger.application.core.exception.ClienteNaoEncontradoException;
import com.fiap.fiapburger.application.core.exception.ExceptionsMessageEnum;
import com.fiap.fiapburger.adapter.out.repository.ClienteRepository;
import com.fiap.fiapburger.application.ports.out.DeletarClienteOutputPort;
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
