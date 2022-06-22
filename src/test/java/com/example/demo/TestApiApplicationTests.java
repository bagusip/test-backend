package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

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
	public void testCreate() {
		Customer c = new Customer();
		c.setId(2L);
		c.setName("tester");
		c.setAge(4L);
		c.setLocation("Senayan");
		customerRepo.save(c);
		assertNotNull(customerRepo.findById(2L).get());
	}
	
	@Test
	public void testReadAllCustomer() {
		List<Customer> list = customerRepo.findAll();
		assertThat(list).size().isGreaterThan(0);
		
	}
	
	@Test
	public void testReadCustomer() {
		Customer customer = customerRepo.findById(2l).get();
		assertEquals("tester", customer.getName());
	}


}
