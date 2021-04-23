package com.rosenhristov.demo;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Rosen Hristov
 */
@Service
public class GreetingService
{

	private static final String URL = "http://greeting";
	private RestTemplate restTemplate;

	public GreetingService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public String getGreeting() {
		return restTemplate.getForObject(URL, String.class);
	}

	public String getGreeting(String locale) {
		return restTemplate.getForObject(
				new StringBuilder()
						.append(URL)
						.append("/")
						.append(locale)
						.toString(),
				String.class);
	}
}
