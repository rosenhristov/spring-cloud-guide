package com.rosenhristov.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;


import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author Rosen Hristov
 */
public class GreetingHandler {
	private static final Logger log = LoggerFactory.getLogger(GreetingHandler.class);


	private WebClient webClient;

	public GreetingHandler(WebClient webClient) {
		this.webClient = webClient;
	}

	public Mono<String> getGreetingStringMono() {
		return webClient
				.get()
				.uri("http://greeting")
				.exchange()
				.flatMap(resp -> resp.bodyToMono(String.class))
				.doOnSuccess(greeting -> log.info("Greeting: {}", greeting));
	}

	public Mono<String> getGreetingStringMono(String locale) {
		log.info("Locale: {}", locale);
		return webClient
				.get()
				.uri("http://greeting/" + locale)
				.exchange()
				.flatMap(response -> response.bodyToMono(String.class))
				.doOnSuccess(greeting -> log.info("Greeting: {}", greeting));
	}
}
