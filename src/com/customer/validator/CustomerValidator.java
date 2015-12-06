package com.customer.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.customer.model.Customer;

@Component
public class CustomerValidator implements Validator {

	@Override
	public boolean supports(Class<?> claz) {
		return Customer.class.isAssignableFrom(claz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		Customer customer = (Customer) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address",
				"error.address", "please select a department");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "error.name",
				"Please enter your name");
		if ("NONE".equals(customer.getDepartment())) {
			errors.rejectValue("department", "error.department",
					"please select a department");
		}
	}

}