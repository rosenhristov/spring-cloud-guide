package com.rosenhristov.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doReturn;

/**
 * @author Rosen Hristov
 */
@RunWith(SpringRunner.class)
public class NameServiceTest {

	@Mock
	RestTemplate restTemplate;

	@Test
	public void getNameTest() {
		doReturn("Rosen").when(restTemplate).getForObject(eq("http://localhost:7070"), eq(String.class));
		NameService nameService = new NameService(restTemplate);
		String name = nameService.getName();
		assertEquals(name, "Rosen");
	}

}