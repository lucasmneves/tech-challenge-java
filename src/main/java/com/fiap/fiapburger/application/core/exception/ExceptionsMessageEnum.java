package com.fiap.fiapburger.application.core.exception;

public enum ExceptionsMessageEnum {
	
	CLIENTE_NAO_ENCONTRADO("Cliente não encontrado!"),
	PRODUTO_NAO_ENCONTRADO("Produto não encontrado!");
	
	private String value;
	
	private ExceptionsMessageEnum(String value) {
		this.value = value;
	}
	
	public String value() {
		return this.value;
	}

}
