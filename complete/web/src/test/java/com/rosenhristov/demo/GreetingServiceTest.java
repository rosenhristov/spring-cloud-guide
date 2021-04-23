package com.rosenhristov.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * @author Rosen Hristov
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT, properties = {"spring.cloud.config.enabled:false"})
@AutoConfigureStubRunner(ids = {"com.example:greeting:+:stubs:0"}, workOffline = true)
@DirtiesContext
public class GreetingServiceTest {

	@Autowired
	GreetingService greetingService;

	@Test
	public void getGreeting() {
		assertEquals("Hello", greetingService.getGreeting());
	}

	@Test
	public void getGreetingWithLocale() {
		String greeting = greetingService.getGreeting("bg");
		assertEquals("Здравейте", greeting);
		greeting = greetingService.getGreeting("ru");
		assertEquals("Здравствуйте", greeting);
		greeting = greetingService.getGreeting("en");
		assertEquals("Hello", greeting);
		greeting = greetingService.getGreeting("de");
		assertEquals("Hallo", greeting);
		greeting = greetingService.getGreeting("es");
		assertEquals("Hola", greeting);

	}

}