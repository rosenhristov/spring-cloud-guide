package com.rosenhristov.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author Rosen Hristov
 */
public class NameHandler {

	private static final Logger log = LoggerFactory.getLogger(NameHandler.class);

	private WebClient webClient;

	public NameHandler(WebClient webClient) {
		this.webClient = webClient;
	}

	public Mono<String> getNameStringMono() {
		return webClient
				.get()
				.uri("http://name")
				.exchange()
				.flatMap(response -> response.bodyToMono(String.class))
				.doOnSuccess(name -> log.info("Name: {}", name));
	}

}
