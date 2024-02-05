package com.jpamapping.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {
	
	@Id
	@GeneratedValue
	
	private int id;
	
	private String name;
	
	private String email;
	
	private String gender;
	
	@OneToMany(targetEntity = Product.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "cust_prod-fk", referencedColumnName = "id")
	private List<Product> products;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY) // CascadeType.ALL: Eşleşen resim verisini silerken kullanıcıyı da siler
	@JoinColumn(name = "user_id")
	private Product product;

}
