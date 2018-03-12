package com.in28minutes.microservices.currencyexchangeservice.fixer;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UnknownCurrencyException extends RuntimeException {

	public UnknownCurrencyException(String info) {
		super(info);
	}

}
