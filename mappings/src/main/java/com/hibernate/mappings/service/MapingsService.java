package com.hibernate.mappings.service;

import java.util.List;
import java.util.Set;

import com.hibernate.mappings.entity.Customer;
import com.hibernate.mappings.entity.Items;
import com.hibernate.mappings.entity.OrdersTable;

import org.springframework.stereotype.Service;

@Service
public interface MapingsService {

	Customer createCustomer(Customer c);

	Customer retriveCustomer(Long customerId);

	Customer updateCustomer(Customer customer, Long customerId);

	void deleteCustomer(Long customerId);

	Set<OrdersTable> createOrder(Set<OrdersTable> orders, Long customerId);

	Items createItem(Items item);

	List<Items> retriveItemsByCategory(String category);

	

}
