package com.rosenhristov.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Rosen Hristov
 */
@RestController
public class NameController {

	private static final Logger log = LoggerFactory.getLogger(NameController.class);

	private NameProperties nameProperties;

	public NameController(NameProperties nameProperties) {
		this.nameProperties = nameProperties;
	}

	@RequestMapping("/")
	public String getName() {
		log.info("Name: {}", nameProperties.getName());
		return nameProperties.getName();
	}
}
