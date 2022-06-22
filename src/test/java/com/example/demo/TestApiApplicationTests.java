package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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
		Customer customer = customerRepo.findById(2L).get();
		assertEquals("tester", customer.getName());
	}

	@Test
	public void testUpdate() {
		Customer customer = customerRepo.findById(3L).get();
		customer.setAge(33L);
		customerRepo.save(customer);
		assertNotEquals(34L, customerRepo.findById(3L).get().getAge());
	}

	@Test
	public void testDelete() {
//		Customer c = new Customer();
//		c.setName("testing_delete");
//		c.setAge(4L);
//		c.setLocation("location");
//		customerRepo.save(c);
		customerRepo.deleteById(12L);
		assertThat(customerRepo.existsById(12L)).isFalse();
	}

}
