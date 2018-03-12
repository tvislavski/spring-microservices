package com.in28minutes.microservices.currencyexchangeservice;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@ConfigurationProperties("currency-exchange-service")
public class Config {

	@Getter @Setter
	private int freshnessTimeFrame;
}
