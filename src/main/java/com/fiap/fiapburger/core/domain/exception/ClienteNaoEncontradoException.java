package com.fiap.fiapburger.core.domain.exception;

public class ClienteNaoEncontradoException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	public ClienteNaoEncontradoException(String exception) {
		super(exception);
	}
}
