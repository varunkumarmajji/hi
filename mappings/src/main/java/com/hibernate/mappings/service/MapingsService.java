package com.hibernate.mappings.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.hibernate.mappings.entity.Address;
import com.hibernate.mappings.entity.Customer;
import com.hibernate.mappings.entity.Items;
import com.hibernate.mappings.entity.OrdersTable;

@Service
public interface MapingsService {

	Customer createCustomer(Customer c);

	Customer retriveCustomer(Long customerId);

	Customer updateCustomer(Customer customer, Long customerId);

	void deleteCustomer(Long customerId);

	Set<OrdersTable> createOrder(Set<OrdersTable> orders, Long customerId);

	Items createItem(Items item);

	List<Items> retriveItemsByCategory(String category);

	Address retriveAddress(Long id);

	Items retriveItems(Long itemId);

}
