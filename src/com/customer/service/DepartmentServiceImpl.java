package com.customer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	private List<String> departments;

	@Override
	public List<String> getAllDepartments() {
		departments = new ArrayList<String>();
		departments.add("Promotions");
		departments.add("Administration");
		departments.add("Engineering");
		departments.add("Sales");
		departments.add("Transport");
		return departments;
	}

}
