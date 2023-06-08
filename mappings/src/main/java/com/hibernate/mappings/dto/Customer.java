package com.hibernate.mappings.dto;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;
	private String customerName;
	private String customerEmail;
	private Long customerNumber;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_address")
	private Address address;
	 @OneToMany(mappedBy = "customer")
	    private List<OrdersTable> orders;
	public Customer() {
		super();
	}
	public Customer(Long customerId, String customerName, String customerEmail, Long customerNumber, Address address,
			List<OrdersTable> orders) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerNumber = customerNumber;
		this.address = address;
		this.orders = orders;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public Long getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(Long customerNumber) {
		this.customerNumber = customerNumber;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<OrdersTable> getOrders() {
		return orders;
	}
	public void setOrders(List<OrdersTable> orders) {
		this.orders = orders;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerEmail="
				+ customerEmail + ", customerNumber=" + customerNumber + ", address=" + address + ", orders=" + orders
				+ "]";
	}
	

}
