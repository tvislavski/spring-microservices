package com.in28minutes.microservices.currencyexchangeservice.fixer;

import java.util.Date;
import java.util.Map;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FixerResponse {

	private boolean success;
	private FixerError error;
	private long timestamp;
	private String base;
	private Date date;
	private Map<String, Double> rates;
}
