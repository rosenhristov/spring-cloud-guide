package com.rosenhristov.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Rosen Hristov
 */
@RestController
public class GreetingController {

	private static final Logger log = LoggerFactory.getLogger(GreetingController.class);

	private GreetingProperties greetingProperties;

	public GreetingController(GreetingProperties greetingProperties) {
		this.greetingProperties = greetingProperties;
	}

	@RequestMapping("/{languageCode}")
	public String getGreeting(@PathVariable String languageCode){
		log.info("Language Code: {}", languageCode);
		log.info("Greeting: {}", greetingProperties
									.getGreetings()
									.get(languageCode.toUpperCase()));
		return greetingProperties
				.getGreetings()
				.getOrDefault(
						languageCode.toUpperCase(),
						greetingProperties.getGreeting()
				);
	}

	@RequestMapping("/")
	public String getGreeting(){
		log.info("Greeting: {}", greetingProperties.getGreeting());
		return greetingProperties.getGreeting();
	}
}
