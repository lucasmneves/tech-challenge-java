package com.fiap.fiapburger.application.core.exception;

public class ClienteNaoEncontradoException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	public ClienteNaoEncontradoException(String exception) {
		super(exception);
	}
}
