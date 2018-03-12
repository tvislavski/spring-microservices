package com.in28minutes.microservices.currencyexchangeservice.exchangeRate;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.in28minutes.microservices.currencyexchangeservice.Config;
import com.in28minutes.microservices.currencyexchangeservice.fixer.FixerResponse;

@Repository
public class ExchangeRatesRepository {

	private HashSet<CachedExchangeRate> cache = new HashSet<>();

	@Autowired
	private Config config;
	@Autowired
	private ExchangeRatesSource exchangeRatesSource;

	public ExchangeRate findByFromAndTo(String from, String to) {
		CachedExchangeRate fromRate = getCachedOrRetrieveFromSource(from);
		CachedExchangeRate toRate = getCachedOrRetrieveFromSource(to);
		ExchangeRate rate = new ExchangeRate();
		rate.setFrom(from);
		rate.setTo(to);
		rate.setRate(toRate.getRate() / fromRate.getRate());
		return rate;
	}
	
	private CachedExchangeRate getCachedOrRetrieveFromSource(String currency) {
		CachedExchangeRate rate = cache.stream().filter(exchangeRate -> exchangeRate.getCurrency().equals(currency))
				.findFirst().orElse(new CachedExchangeRate());
		if (!rate.isFresh(config.getFreshnessTimeFrame())) {
			rate.setCurrency(currency);
			rate.setRate(retrieveFromSource(currency));
			cache.add(rate);
		}
		return rate;
	}

	private Double retrieveFromSource(String currency) {
		FixerResponse response = exchangeRatesSource.retrieveExchangeValue(CachedExchangeRate.EURO, currency);
		if (response.getError() != null) {
			throw response.getError().createException();
		}
		return response.getRates().get(currency);
	}
}
