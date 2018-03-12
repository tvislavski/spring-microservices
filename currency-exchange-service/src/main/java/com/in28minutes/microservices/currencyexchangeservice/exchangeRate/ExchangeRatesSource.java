package com.in28minutes.microservices.currencyexchangeservice.exchangeRate;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.in28minutes.microservices.currencyexchangeservice.fixer.FixerResponse;

@FeignClient(name="exchange-rates-source", url="http://data.fixer.io/api/latest?access_key=fe0169c4b546d5fa2fcedf14cd3c1429")
interface ExchangeRatesSource {

	@GetMapping
	public FixerResponse retrieveExchangeValue
		(@RequestParam("base") String base, @RequestParam("symbols") String symbols);
}
