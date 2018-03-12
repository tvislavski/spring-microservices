package com.in28minutes.microservices.currencyconversionservice;

import lombok.Data;

@Data
public class CurrencyConversionBean {
	
	private String from;
	private String to;
	private Double rate;
	private Double quantity;
	private Double calculatedAmount;
	private int port;

}
