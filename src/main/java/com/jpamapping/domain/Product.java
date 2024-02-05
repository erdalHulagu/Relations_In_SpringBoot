package com.jpamapping.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


	@Entity
	@Table
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public class Product {
		
		@Id
		@GeneratedValue
		private int id;
		
		private String productName;
		
		private int quantity;
		
		private double price;
		
		
}
