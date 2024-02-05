package com.jpamapping.repository;

import java.lang.StackWalker.Option;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpamapping.domain.Product;
import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Integer>{
//	Optional<Product>findById(int id);

}
