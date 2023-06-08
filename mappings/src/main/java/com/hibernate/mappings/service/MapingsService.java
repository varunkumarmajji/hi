package com.hibernate.mappings.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hibernate.mappings.dto.Customer;
import com.hibernate.mappings.dto.OrdersTable;

@Service
public interface MapingsService {

	Customer createCustomer(Customer c);

	Customer retriveCustomer(Long customerId);

	Customer updateCustomer(Customer customer, Long customerId);

	void deleteCustomer(Long customerId);

	List<OrdersTable> createOrder(List<OrdersTable> orders, Long customerId);

}
