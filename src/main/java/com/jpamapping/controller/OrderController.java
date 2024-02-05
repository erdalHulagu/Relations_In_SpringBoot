package com.jpamapping.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
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

@RestController
public class OrderController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	
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
	public ResponseEntity <Customer> findById(@PathVariable Integer id){
		
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
	@GetMapping("/customer/{id}")
	public ResponseEntity<Boolean> getProductByCutomer(@RequestBody OrderRequest orderRequest, @PathVariable Integer productId){
		Product product=	productRepository.findById(productId).orElseThrow(()->new ResourceNotFoundException(String.format("Product not found  id with "+ productId)));
		
boolean	customer=customerRepository.findById(orderRequest.getCustomer().getProduct().getId()).equals(product.getId());
		
	if (customer!=) {
		
	        throw new 	ResourceNotFoundException(String.format("Product not found  id with "+productId));
	};
		
		return ResponseEntity.ok(customer) ;
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

	

}
