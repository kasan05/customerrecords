package com.customer.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.customer.model.Customer;
import com.customer.service.CustomerService;
import com.customer.service.DepartmentService;
import com.customer.service.LogService;
import com.customer.validator.CustomerValidator;

@Controller
@RequestMapping("/")
public class CustomerOpContoller {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private LogService logService;

	@Autowired
	private DepartmentService departmentService;

	@Autowired
	private CustomerValidator customerValidator;

	@RequestMapping("/")
	public String ridirectToCustomer() {
		return "redirect:/customers";
	}

	@RequestMapping(value = "/customer/add", method = RequestMethod.POST)
	public String addCustomer(
			@ModelAttribute("customer") @Validated Customer customer,
			BindingResult result) {
		customerValidator.validate(customer, result);
		if (result.hasErrors()) {
			return "customer";
		}
		if (customer.getCustomer_id() == 0) {
			customerService.saveCustomer(customer);
			logService.log("Customer id = " + customer.getCustomer_id()
					+ " is added", new Date());
		} else {
			customerService.updateCustomer(customer);
			logService.log("Customer id = " + customer.getCustomer_id()
					+ " is edited", new Date());
		}
		return "redirect:/customers";
	}

	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	public String findAllCustomers(Model model) {
		model.addAttribute("customer", new Customer());
		model.addAttribute("listCustomers", customerService.findAll());
		model.addAttribute("departmentList",
				departmentService.getAllDepartments());
		return "customer";
	}

	@RequestMapping("/customer/delete/{id}")
	public String deleteCustomer(@PathVariable("id") int id) {
		customerService.deleteCustomer(id);
		logService.log("Customer id = " + id + " is deleted", new Date());
		return "redirect:/customers";
	}

	@RequestMapping("/customer/edit/{id}")
	public String editCustomer(@PathVariable("id") int id, Model model) {
		model.addAttribute("customer",
				customerService.getCustomerByCustomerId(id));
		model.addAttribute("listCustomers", customerService.findAll());
		model.addAttribute("departmentList",
				departmentService.getAllDepartments());
		return "customer";
	}

}
