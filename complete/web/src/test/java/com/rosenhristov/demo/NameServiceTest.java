package com.rosenhristov.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;

/**
 * @author Rosen Hristov
 */
@RunWith(SpringRunner.class)
@SpringBootTest(
		webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT,
		properties = {"spring.cloud.config.enabled:false"})
@AutoConfigureStubRunner(ids = {"com.example:name:+:stubs:0"}, workOffline = true)
public class NameServiceTest {

	@Autowired
	NameService nameService;

	@Test
	public void getNameTest() {
		String name = nameService.getName();
		assertEquals("Rosen", name);
	}

}