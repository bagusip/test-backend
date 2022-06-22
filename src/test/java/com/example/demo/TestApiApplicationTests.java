package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.controller.CustomerController;

public class TestApiApplicationTests {

	@Autowired
	CustomerController controller = new CustomerController();
	
	@Test
	void test() {
		
		String responseString = controller.hello("World");
		assertEquals("Hello, World", responseString);
	}


}
