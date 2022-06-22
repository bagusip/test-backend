package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

	
public class CustomerControllerTest {

	
	@Autowired
	CustomerController controller = new CustomerController();
	
	@Test
	void test() {
		
		String responseString = controller.hello("World");
		assertEquals("Hello, World", responseString);
	}

}
