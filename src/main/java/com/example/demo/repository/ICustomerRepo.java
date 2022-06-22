package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Customer;

public interface ICustomerRepo extends JpaRepository<Customer, Long>{
//	Long deleteByName(String name);
	List<Customer> deleteByName(String name);
	
	@Modifying
	@Query("DELETE FROM tbl_customer where name = ?1")
	Long removeByName(String name);
}
