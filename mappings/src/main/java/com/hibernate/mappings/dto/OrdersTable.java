package com.hibernate.mappings.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OrdersTable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String orderNumber;
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	private int orderStatus;
	public OrdersTable(Long id, String orderNumber, Customer customer, int orderStatus) {
		super();
		this.id = id;
		this.orderNumber = orderNumber;
		this.customer = customer;
		this.orderStatus = orderStatus;
	}
	public OrdersTable() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public int getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}
	@Override
	public String toString() {
		return "OrdersTable [id=" + id + ", orderNumber=" + orderNumber + ", customer=" + customer + ", orderStatus="
				+ orderStatus + "]";
	}

	
}
