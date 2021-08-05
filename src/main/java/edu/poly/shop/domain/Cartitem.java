package edu.poly.shop.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cartitem {
	private int productId;
	private String name;
	private int quantity;
	private double unitPrice;
}
