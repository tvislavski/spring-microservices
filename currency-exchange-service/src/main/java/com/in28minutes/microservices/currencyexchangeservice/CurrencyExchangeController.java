package com.in28minutes.microservices.currencyexchangeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.microservices.currencyexchangeservice.exchangeRate.ExchangeRate;
import com.in28minutes.microservices.currencyexchangeservice.exchangeRate.ExchangeRatesRepository;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private Environment environment;
	
	@Autowired
	private ExchangeRatesRepository repository;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeRate retrieveExchangeValue
		(@PathVariable String from, @PathVariable String to){
		ExchangeRate exchangeRate = 
				repository.findByFromAndTo(from, to);
		exchangeRate.setPort(
				Integer.parseInt(environment.getProperty("local.server.port")));
		return exchangeRate;
	}
}
