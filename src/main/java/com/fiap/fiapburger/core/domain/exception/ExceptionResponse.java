
package com.fiap.fiapburger.core.domain.exception;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;


@Getter
public class ExceptionResponse implements Serializable{
	public ExceptionResponse(Date timestamp, String message, String details) {
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	private static final long serialVersionUID = 1L;
	private final Date timestamp;
	private final String message;
	private final String details;
}

