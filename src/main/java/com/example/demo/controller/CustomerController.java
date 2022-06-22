package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customer;
import com.example.demo.repository.ICustomerRepo;


@RestController
public class CustomerController {
	
	@Autowired
	ICustomerRepo customerRepo;
	
	@PostMapping("/customers")
	public ResponseEntity<Customer> Save(@RequestBody Customer customer){
		try {
			return new ResponseEntity<>(customerRepo.save(customer), HttpStatus.CREATED);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomer(){
		try {
			List<Customer> list = customerRepo.findAll();
			if(list.isEmpty() || list.size() == 0) {
				return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<List<Customer>>(list,HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> getSingleCustomer(@PathVariable Long id){
		Optional<Customer> customer = customerRepo.findById(id);
		
		if(customer.isPresent()) {
			return new ResponseEntity<Customer>(customer.get(),HttpStatus.OK);
		}
		
		return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/customers/update/{id}")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){
		try {
			return new ResponseEntity<Customer>(customerRepo.save(customer),HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<Customer>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/customers/delete/{id}")
	public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable Long id){
		try {
			Optional<Customer> customer = customerRepo.findById(id);
			if(customer.isPresent()) {
				customerRepo.delete(customer.get());
			}
			return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
		}
		catch (Exception e) {
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public String hello(String name) {
		return String.format("Hello, %s", name);
	}
}
