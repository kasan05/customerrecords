package com.customer.service;

import java.util.List;

import com.customer.model.Customer;

public interface CustomerService {

	public void saveCustomer(Customer customer);

	public List<Customer> findAll();

	public Customer getCustomerByCustomerId(int id);

	public void deleteCustomer(int id);

	public void updateCustomer(Customer customer);
}
