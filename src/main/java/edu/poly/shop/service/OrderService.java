package edu.poly.shop.service;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import edu.poly.shop.domain.Order;

public interface OrderService {

	Order create(JsonNode orderData); 

	Order findById(Long Id);


	List<Order> findByUsername(String username);

}
