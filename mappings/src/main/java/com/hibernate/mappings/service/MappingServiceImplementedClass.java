package com.hibernate.mappings.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibernate.mappings.dto.Customer;
import com.hibernate.mappings.dto.OrdersTable;
import com.hibernate.mappings.repository.AddressRepo;
import com.hibernate.mappings.repository.CustomerRepo;
import com.hibernate.mappings.repository.OrderRepo;

@Service
public class MappingServiceImplementedClass implements MapingsService {
	@Autowired
	private CustomerRepo cusRepo;
	@Autowired
	private AddressRepo addRepo;
	@Autowired
	private OrderRepo oddRepo;
	@Override
	public Customer createCustomer(Customer c) {

		addRepo.save(c.getAddress());
		return cusRepo.save(c);
	}

	@Override
	public Customer retriveCustomer(Long customerId) {

		return cusRepo.findById(customerId).get();
	}

	@Override
	public Customer updateCustomer(Customer customer, Long customerId) {
		Customer old = cusRepo.findById(customerId).get();
		if (customer.getCustomerName() != null) {
			old.setCustomerName(customer.getCustomerName());
		}
		if (customer.getCustomerEmail() != null) {
			old.setCustomerEmail(customer.getCustomerEmail());
		}
		if (customer.getCustomerNumber() != null) {
			old.setCustomerNumber(customer.getCustomerNumber());
		}
		if (customer.getAddress().getCity() != null) {
			old.getAddress().setCity(customer.getAddress().getCity());
		}
		if (customer.getAddress().getStreet() != null) {
			old.getAddress().setStreet(customer.getAddress().getStreet());
		}
		if (customer.getAddress().getZipCode() != null) {
			old.getAddress().setZipCode(customer.getAddress().getZipCode());
		}

		return cusRepo.save(old);
	}

	@Override
	public void deleteCustomer(Long customerId) {
		cusRepo.deleteById(customerId);
	}

	@Override
	public List<OrdersTable> createOrder(List<OrdersTable> orders, Long customerId) {
		Customer old = cusRepo.findById(customerId).get();
		
		Iterator<OrdersTable> iterator = orders.iterator();
		while (iterator.hasNext()) {
		    OrdersTable order = iterator.next();
		   order.setCustomer(old);
		   oddRepo.save(order);
		}
		return orders;
	}

}
