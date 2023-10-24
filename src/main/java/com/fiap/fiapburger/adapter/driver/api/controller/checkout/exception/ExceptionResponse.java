package com.fiap.fiapburger.adapter.driver.api.controller.checkout.exception;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ExceptionResponse implements Serializable{

	private static final long serialVersionUID = 1L;
	private final Date timestamp;
	private final String message;
	private final String details;
}
