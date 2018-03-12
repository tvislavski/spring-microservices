package com.in28minutes.microservices.currencyexchangeservice.exchangeRate;

import java.util.Calendar;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(exclude = { "timestamp", "rate"})
class CachedExchangeRate {

	/*
	 * All currencies are relative to Euro : 1 EUR = rate currency
	 */
	public static final String EURO = "EUR";
	
	private String currency;
	private Date timestamp;
	private Double rate;

	public boolean isFresh(int freshnessTimeFrame) {
		if (timestamp == null)
			return false;
		Calendar cal = Calendar.getInstance();
		cal.setTime(timestamp);
		cal.add(Calendar.MILLISECOND, freshnessTimeFrame);
		return cal.after(Calendar.getInstance());
	}

	public void setRate(Double rate) {
		this.rate = rate;
		timestamp = Calendar.getInstance().getTime();
	}
}
