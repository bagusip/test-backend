package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.apache.naming.java.javaURLContextFactory;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.controller.CustomerController;
import com.example.demo.entity.Customer;
import com.example.demo.repository.ICustomerRepo;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class TestApiApplicationTests {

	@Autowired
	ICustomerRepo customerRepo;
	
	@Autowired
	CustomerController controller = new CustomerController();

	@Test
	@Order(1)
	public void testCreate() {
		Customer c = new Customer();
		c.setId(15L);
		c.setName("tester");
		c.setAge(4L);
		c.setLocation("Senayan");
		customerRepo.save(c);
		assertNotNull(customerRepo.findById(15L).get());
	}

	@Test
	@Order(2)
	public void testReadAllCustomer() {
		List<Customer> list = customerRepo.findAll();
		assertThat(list).size().isGreaterThan(0);

	}

	@Test
	@Order(3)
	public void testReadCustomer() {
		Customer customer = customerRepo.findById(15L).get();
		assertEquals("tester", customer.getName());
	}

	@Test
	@Order(4)
	public void testUpdate() {
		Customer customer = customerRepo.findById(15L).get();
		customer.setAge(33L);
		customerRepo.save(customer);
		assertNotEquals(34L, customerRepo.findById(15L).get().getAge());
	}

	@Test
	@Order(5)
	public void testDelete() {
		customerRepo.deleteById(15L);
		assertThat(customerRepo.existsById(15L)).isFalse();
	}
	
	@Test
	@Order(6)
	void test() {
		
		String responseString = controller.hello("World");
		assertEquals("Hello, Bagus", responseString);
	}

}
