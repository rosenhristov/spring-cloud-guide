package com.rosenhristov.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * @author Rosen Hristov
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, properties = {"spring.cloud.config.enabled:false"})
@TestPropertySource(locations = {"classpath:test.properties"})
public class GreetingApplicationTests {

	@Autowired
	TestRestTemplate restTemplate;

	@Test
	public void contextLoads() {
		String deGreeting = this.restTemplate.getForObject("/de", String.class);
		String enGreeting = this.restTemplate.getForObject("/en", String.class);
		String esGreeting = this.restTemplate.getForObject("/es", String.class);
		String bgGreeting = this.restTemplate.getForObject("/bg" , String.class);
		String ruGreeting = this.restTemplate.getForObject("/ru" , String.class);
		String defaultGreeting = this.restTemplate.getForObject("/", String.class);
		assertEquals("Здравейте", bgGreeting);
		assertEquals("Здравствуйте", ruGreeting);
		assertEquals("Hallo", deGreeting);
		assertEquals("Hello", enGreeting);
		assertEquals("Hola", esGreeting);
		assertEquals("Hello", defaultGreeting);
	}

}
