package com.jpamapping.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpamapping.domain.Customer;
import com.jpamapping.domain.Product;
import com.jpamapping.repository.CustomerRepository;
import com.jpamapping.repository.ProductRepository;
import com.jpamapping.request.OrderRequest;
import com.jpamapping.response.OrderResponse;
import com.jpamapping.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderService orderService;
	
	
	@PostMapping("/placeOrder")
	public ResponseEntity<String> placeOrder(@RequestBody OrderRequest orderRequest) {
		
		customerRepository.save(orderRequest.getCustomer());
		
		return ResponseEntity.ok("Orders has been saved succesfully");
		
		
	}
	
	@GetMapping("/findAllOrders")
	public ResponseEntity<List<Customer>> findAllOrders(){
		
		List<Customer> customers =customerRepository.findAll();
		
		return ResponseEntity.ok(customers);
		
		
	}
	@GetMapping("/{id}")
	public ResponseEntity <Customer> findCustomerById(@PathVariable Integer id){
		
		Customer customer= customerRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(String.format("Customer not found with id"+id)));
		
		return ResponseEntity.ok(customer);
		
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Integer id){
		
		customerRepository.deleteById(id);
		
		return ResponseEntity.ok("customer deleted succesfully");
		
		
	}
	@GetMapping("/findInfo")
	public ResponseEntity<List<OrderResponse>> getInformation(){
		
		List<OrderResponse> customer= customerRepository.getInformation();
		
		return ResponseEntity.ok(customer);
		
		
	}
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable @Validated Integer id){
		
	Product product=	productRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(String.format("Product not found  id with "+ id)));
//		if (product == null) {
//			
//			new ResourceNotFoundException(String.format(" product is not available with "+id));
//		}
//		
//		return ResponseEntity.ok(product);
		return ResponseEntity.ok(product);
	}
//	@GetMapping("/customer/{id}")
//	public ResponseEntity< Customer> getProductByCutomer(@RequestBody OrderRequest orderRequest, @PathVariable Integer id){
//		ResponseEntity<Product> product=	getProductById(id);
//		
//	
//		
//  ResponseEntity<Customer> customer= findCustomerById(orderRequest.getCustomer().getProduct().getId());
//  
//  if (customer.getBody().getProduct().getId()!=product.getBody().getId()) {
//	  
//	  throw new 	ResourceNotFoundException(String.format("Product not found  id with "+orderRequest.getCustomer().getName()));
//}
//	
//		return ResponseEntity.ok(product) ;
//	}

	@GetMapping("/customer/{id}")
	public ResponseEntity<Product> getProductByCutomer( @PathVariable Integer id, @RequestBody Customer customerId){
	
		Customer customer= customerRepository.findById(customerId.getId()).orElseThrow(()->new ResourceNotFoundException(String.format("Customer not found with id"+customerId)));
		
		
		Product product= productRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(String.format("Customer not found with id"+id)));
		
		if (customer.getProducts().contains(product)) {
			
		}
		
return ResponseEntity.ok(product);
		
	}
//	Customer customer=	customerRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(String.format("Product not found  id with "+ id)));
//	
////     ResponseEntity<Product> product= getProductById(productId);
//                                
//                                if (customer.getProduct().getId()!=productId) {
//									return null;
//								}
//   
//
//		return ResponseEntity.ok(customer);
//	}



};

	


