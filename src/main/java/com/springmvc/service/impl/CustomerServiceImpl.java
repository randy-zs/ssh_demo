package com.springmvc.service.impl;

import com.springmvc.dao.CustomerDao;
import com.springmvc.dto.Customer;
import com.springmvc.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao customerDao;

	@Override
	public void addCustomer(Customer customer) {
		customerDao.addCustomer(customer);
	}
}
