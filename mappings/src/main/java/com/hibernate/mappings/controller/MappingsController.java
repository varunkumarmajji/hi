package com.hibernate.mappings.controller;

import java.util.List;
import java.util.Set;

import com.hibernate.mappings.entity.Address;
import com.hibernate.mappings.entity.Customer;
import com.hibernate.mappings.entity.Items;
import com.hibernate.mappings.entity.OrdersTable;
import com.hibernate.mappings.service.MapingsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MappingsController {
	@Autowired
	private MapingsService service;
//One-one
	//registering customer with address
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
	//getting single customer details with his address
	@GetMapping("/get/{customerId}")
	public Customer getOneCustomer(@PathVariable Long customerId) {
	
		return service.retriveCustomer(customerId);

	}
	//modifying customer details and his address details
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
	//deleting customer account
	@DeleteMapping("/delete/{customerId}")
	public String deleteCustomer(@PathVariable Long customerId) {
		service.deleteCustomer(customerId);
		return "customer deleted Successfully";

	}
	//creating items
	@PostMapping("/saveitems")
	public String additem(@RequestBody Items item) {
		Items newitem = service.createItem(item);
		String msg = null;
		if (newitem != null) {
			msg = "new item added successfully";
		} else {
			msg = "failed";
		}

		return msg;

	}
	//retriving items by category
	@GetMapping("/getitems/{category}")
	public List<Items> getItemsByCategory(@PathVariable String category) {
	
		return service.retriveItemsByCategory(category);

	}
	//update item 
	//delete items
	//one-many,many-one
	//customer placing multiple orders containing multiple items
	@PostMapping("/order/{customerId}")
	public String Order(@RequestBody Set<OrdersTable> orders , @PathVariable Long customerId) {
		Set<OrdersTable> o = service.createOrder(orders, customerId);
		String msg = null;
		if (o != null) {
			msg = "orders placed successfully";
		} else {
			msg = "failed";
		}

		return msg;

	}
	@GetMapping("/getaddress/{id}")
	public Address getAddress(@PathVariable Long id) {
	
		return service.retriveAddress(id);

	}
	@GetMapping("/getitem/{itemId}")
	public Items getItem(@PathVariable Long itemId) {
	
		return service.retriveItems(itemId);

	}
}
