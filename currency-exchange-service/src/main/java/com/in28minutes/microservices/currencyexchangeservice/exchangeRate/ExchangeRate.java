package com.in28minutes.microservices.currencyexchangeservice.exchangeRate;

import lombok.Data;

@Data
public class ExchangeRate {

	private String from;
	private String to;
	private Double rate;
	private int port;
}
