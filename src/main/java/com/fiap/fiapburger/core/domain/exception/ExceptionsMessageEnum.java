package com.fiap.fiapburger.core.domain.exception;

public enum ExceptionsMessageEnum {
	
	CLIENTE_NAO_ENCONTRADO("Cliente não encontrado!"),
	PRODUTO_NAO_ENCONTRADO("Produto não encontrado!"),
	PEDIDO_NAO_ENCONTRADO("Pedido não encontrado!");
	
	private String value;
	
	private ExceptionsMessageEnum(String value) {
		this.value = value;
	}
	
	public String value() {
		return this.value;
	}

}
