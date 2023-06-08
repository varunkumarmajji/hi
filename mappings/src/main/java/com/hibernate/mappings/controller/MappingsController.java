package com.hibernate.mappings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hibernate.mappings.dto.Customer;
import com.hibernate.mappings.dto.OrdersTable;
import com.hibernate.mappings.service.MapingsService;

@RestController
public class MappingsController {
	@Autowired
	private MapingsService service;

	@PostMapping("/save")
	public String addUser(@RequestBody Customer c) {
		Customer cus = service.createCustomer(c);
		String msg = null;
		if (cus != null) {
			msg = "new Customer Account created successfully";
		} else {
			msg = "Customer account creation failed";
		}

		return msg;

	}
	@GetMapping("/get/{customerId}")
	public Customer getOneCustomer(@PathVariable Long customerId) {
	
		return service.retriveCustomer(customerId);

	}
	@PutMapping("/update/{customerId}")
	public String updateUser(@RequestBody Customer customer, @PathVariable Long customerId) {
		Customer cus = service.updateCustomer(customer, customerId);
		String msg = null;
		if (cus != null) {
			msg = "Customer details modified successfully";
		} else {
			msg = "Customer modification failed";
		}

		return msg;

	}
	@DeleteMapping("/delete/{customerId}")
	public String deleteCustomer(@PathVariable Long customerId) {
		service.deleteCustomer(customerId);
		return "customer deleted Successfully";

	}
	@PostMapping("/order/{customerId}")
	public String Order(@RequestBody List<OrdersTable> orders , @PathVariable Long customerId) {
		List<OrdersTable> o = service.createOrder(orders, customerId);
		String msg = null;
		if (o != null) {
			msg = "orders placed successfully";
		} else {
			msg = "failed";
		}

		return msg;

	}

}
