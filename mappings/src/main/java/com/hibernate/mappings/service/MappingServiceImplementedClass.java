package com.hibernate.mappings.service;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.hibernate.mappings.entity.Customer;
import com.hibernate.mappings.entity.Items;
import com.hibernate.mappings.entity.OrdersTable;
import com.hibernate.mappings.repository.AddressRepo;
import com.hibernate.mappings.repository.CustomerRepo;
import com.hibernate.mappings.repository.ItemsRepo;
import com.hibernate.mappings.repository.OrderRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MappingServiceImplementedClass implements MapingsService {
	@Autowired
	private CustomerRepo cusRepo;
	@Autowired
	private AddressRepo addRepo;
	@Autowired
	private OrderRepo oddRepo;
	@Autowired
	private ItemsRepo itemRepo;
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
		
		if (customer.getCustomerFirstName() != null) {
			old.setCustomerFirstName(customer.getCustomerFirstName());
		}
		if (customer.getCustomerLastName() != null) {
			old.setCustomerLastName(customer.getCustomerLastName());
		}
		if (customer.getCustomerEmail() != null) {
			old.setCustomerEmail(customer.getCustomerEmail());
		}
		if (customer.getCustomerDob() != null) {
			old.setCustomerDob(customer.getCustomerDob());
		}
		if (customer.getCustomerGender() != null) {
			old.setCustomerGender(customer.getCustomerGender());
		}
		if (customer.getCustomerNumber() != null) {
			old.setCustomerNumber(customer.getCustomerNumber());
		}
		if(customer.getAddress()!= null) {
		if (customer.getAddress().getCity() != null) {
			old.getAddress().setCity(customer.getAddress().getCity());
		}
		if (customer.getAddress().getStreet() != null) {
			old.getAddress().setStreet(customer.getAddress().getStreet());
		}
		if (customer.getAddress().getZipCode() != null) {
			old.getAddress().setZipCode(customer.getAddress().getZipCode());
		}
		if (customer.getAddress().getState() != null) {
			old.getAddress().setState(customer.getAddress().getState());
		}
		if (customer.getAddress().getCountry() != null) {
			old.getAddress().setCountry(customer.getAddress().getCountry());
		}
		}

		return cusRepo.save(old);
	}

	@Override
	public void deleteCustomer(Long customerId) {
		cusRepo.deleteById(customerId);
	}

	@Override
	public Set<OrdersTable> createOrder(Set<OrdersTable> orders, Long customerId) {
		Customer old = cusRepo.findById(customerId).get();
		
		Iterator<OrdersTable> iterator = orders.iterator();
		while (iterator.hasNext()) {
		    OrdersTable order = iterator.next();
		             order.setOrderStatus(0);       
		   order.setCustomer(old);
		order.setOrderQuantity(order.getItemses().size());
		Iterator<Items> iterator1 = order.getItemses().iterator();
		while (iterator1.hasNext()) {
			Items item=iterator1.next();
			Double sum=0.0;
			order.setTotalPrice(sum+itemRepo.findById(item.getItemId()).get().getPrice());
		}
		
		   oddRepo.save(order);
		}
		return orders;
	}

	@Override
	public Items createItem(Items item) {
		
		return itemRepo.save(item);
	}

	@Override
	public List<Items> retriveItemsByCategory(String category) {
		return itemRepo.findByCategory(category);
	}

}
