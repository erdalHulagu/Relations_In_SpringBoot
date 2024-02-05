package com.jpamapping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jpamapping.repository.CustomerRepository;
import com.jpamapping.repository.ProductRepository;

@org.springframework.stereotype.Service
@Component
public class OrderService {

	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
}
