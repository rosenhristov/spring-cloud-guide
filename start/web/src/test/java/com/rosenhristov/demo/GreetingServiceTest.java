package com.rosenhristov.demo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Incubating;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

/**
 * @author Rosen Hristov
 */
@RunWith(SpringRunner.class)
public class GreetingServiceTest {

	@Mock
	RestTemplate restTemplate;

	@InjectMocks
	private GreetingService greetingService;

	@Before
	public void setup() {
		doReturn("Hello").when(restTemplate).getForObject(eq("http://localhost:9090"), eq(String.class));
		doReturn("Hello").when(restTemplate).getForObject(eq("http://localhost:9090/en"), eq(String.class));
		doReturn("Hola").when(restTemplate).getForObject(eq("http://localhost:9090/es"), eq(String.class));
	}

	@After
	public void teardown() {
		greetingService = null;
	}

	@Test
	public void getGreeting() {
		assertEquals("Hello", greetingService.getGreeting());
	}

	@Test
	public void getGreetingWithLocale() {
		assertEquals("Hello", greetingService.getGreeting("en"));
		assertEquals("Hola", greetingService.getGreeting("es"));
	}

}