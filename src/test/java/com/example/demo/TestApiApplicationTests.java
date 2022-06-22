package com.example.demo;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.naming.java.javaURLContextFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.controller.CustomerController;
import com.example.demo.entity.Customer;
import com.example.demo.repository.ICustomerRepo;

@SpringBootTest
public class TestApiApplicationTests {

	@Autowired
	ICustomerRepo customerRepo;

	@Test
	void testCreate() {
		Customer c = new Customer();
		c.setId(2L);
		c.setName("tester");
		c.setAge(4L);
		c.setLocation("Senayan");
		customerRepo.save(c);
		assertNotNull(customerRepo.findById(2L).get());
	}


}
