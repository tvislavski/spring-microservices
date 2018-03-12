package com.in28minutes.microservices.currencyexchangeservice.fixer;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
public class GeneralFixerException extends RuntimeException {

	public GeneralFixerException(String info) {
		super(info);
	}

}
