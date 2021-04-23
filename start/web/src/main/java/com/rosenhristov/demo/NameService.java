package com.rosenhristov.demo;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Rosen Hristov
 */
@Service
public class NameService {

	private static final String URL = "http://localhost:7070";
	private RestTemplate restTemplate;

	public NameService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public String getName() {
		return restTemplate.getForObject(URL, String.class);
	}
}
