
package com.cglia.user.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.cglia.user.model.CustomerRestCall;

@Service
public interface CustomerService {
	public String createCustomer(CustomerRestCall c) throws IOException, InterruptedException;

	public String retriveCustomer(Integer customerId) throws IOException, InterruptedException;

	public String updateCustomer(CustomerRestCall c, Integer customerId) throws IOException, InterruptedException;

	public String deleteCustomer(Integer customerId) throws IOException, InterruptedException;

}
