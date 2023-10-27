package com.fiap.fiapburger.adapter.driver.api.controller.checkout.exception;

public class ClienteNaoEncontradoException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	public ClienteNaoEncontradoException(String exception) {
		super(exception);
	}
}
