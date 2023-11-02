package com.fiap.fiapburger.application.core.exception;

import java.io.Serial;

public class ProdutoNaoEncontradoException extends RuntimeException{


    @Serial
    private static final long serialVersionUID = -7583046868678964928L;

    public ProdutoNaoEncontradoException(String exception) {
        super(exception);
    }
}