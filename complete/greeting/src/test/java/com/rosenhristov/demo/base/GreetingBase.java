package com.rosenhristov.demo.base;

import com.rosenhristov.demo.GreetingController;
import com.rosenhristov.demo.GreetingProperties;
import io.restassured.module.mockmvc.RestAssuredMockMvc;

import java.util.HashMap;
import java.util.Map;
import org.junit.Before;

/**
 * @author Rosen Hristov
 */
public class GreetingBase {

	@Before
	public void setup() {
		GreetingProperties greetingProperties = new GreetingProperties();
		greetingProperties.setGreeting("Hello");
		greetingProperties.setGreetings(
			Map.of(
				"BG", "Здравейте",
				"RU", "Здравствуйте",
				"EN", "Hello",
				"DE", "Hallo",
				"ES", "Hola")
		);

		RestAssuredMockMvc.standaloneSetup(
				new GreetingController(greetingProperties));
	}
}
