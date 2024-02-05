package com.jpamapping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;

import com.jpamapping.domain.Customer;
//import com.jpamapping.domain.Product;
import com.jpamapping.response.OrderResponse;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	
	
	@Query("SELECT new com.jpamapping.response.OrderResponse ( c.name, p.productName, p.price ) FROM Customer c join c.products p")
	public List<OrderResponse> getInformation();


//	@Modifying
//	@Query("SELECT c from Customer c join c.product p where p.id=:id")
//	public List<Customer> findByProductId(@Param("id") int id);
	@Modifying
	@Query("SELECT com.jpamapping.domain.Customer ( c ) from Customer c join c.product p where p.id=:id")
	public Customer findByProductId(@Param("id") int id);
//
//	@Query("SELECT  Product p FROM Customer c Join c.product.id = productId ")
//	public Customer getProductById( Product productId);
//	 @Query("SELECT c FROM Costumer  c join c.products p where p.id=id ")
//	 public List<Product> findProductByUserId(@Param("id") Integer CudtomerId);


//    @Query("SELECT p.productName,p.price,p.quantity FROM Customer c join c.products p ")
//	public Customer getCustomersProductByIdCustomer(Customer customer);


	

}
