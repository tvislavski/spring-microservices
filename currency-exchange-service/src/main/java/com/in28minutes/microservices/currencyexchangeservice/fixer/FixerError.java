package com.in28minutes.microservices.currencyexchangeservice.fixer;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FixerError {

	private int code;
	private String info;

	public RuntimeException createException() {
		if (code == 202)
			return new UnknownCurrencyException(info);
		return new GeneralFixerException(info);
	}
}
