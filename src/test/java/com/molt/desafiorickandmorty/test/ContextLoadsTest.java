package com.molt.desafiorickandmorty.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class ContextLoadsTest {
	
	@Autowired
    ApplicationContext applicationContext;

	@Test
	@DisplayName("contextLoadsTest")
	void contextLoadsTest() {
		assertNotNull(applicationContext);
	}

}
