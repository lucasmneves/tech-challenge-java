package com.fiap.fiapburger.adapter.driver.api.controller.checkout.exception;

public enum ExceptionsMessageEnum {
	
	CLIENTE_NAO_ENCONTRADO("Cliente não encontrado!");
	
	private String value;
	
	private ExceptionsMessageEnum(String value) {
		this.value = value;
	}
	
	public String value() {
		return this.value;
	}

}
