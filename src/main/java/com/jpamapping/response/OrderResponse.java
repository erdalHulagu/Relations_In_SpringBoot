package com.jpamapping.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderResponse {
	
	private String name;
	private String productName;
	private double price;
	private int quantity; 

}
