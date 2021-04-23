package com.rosenhristov.demo.base;

import com.rosenhristov.demo.NameController;
import com.rosenhristov.demo.NameProperties;
import io.restassured.module.mockmvc.RestAssuredMockMvc;

import org.junit.Before;

/**
 * @author Rosen Hristov
 */
public class NameBase {

	@Before
	public void setup() {
		NameProperties nameProperties = new NameProperties();
		nameProperties.setName("Ryan");
		RestAssuredMockMvc.standaloneSetup(new NameController(nameProperties));
	}
}
