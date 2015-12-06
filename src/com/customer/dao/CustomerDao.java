package com.customer.dao;

import java.util.List;

import com.customer.model.Customer;

public interface CustomerDao {

	public void createCustomer(Customer customer);

	public List<Customer> findAll();

	public Customer getCustomerByCustomerId(int id);

	public void deleteCustomerById(int id);

	public void updateCustomer(Customer customer);
}