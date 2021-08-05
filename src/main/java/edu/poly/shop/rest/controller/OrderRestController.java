package edu.poly.shop.rest.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;

import edu.poly.shop.domain.Order;
import edu.poly.shop.domain.Product;
import edu.poly.shop.service.OrderService;
import edu.poly.shop.service.ProductService;


@CrossOrigin("*")
@RestController
@RequestMapping("/rest/orders")
public class OrderRestController {
	@Autowired
	OrderService os;

	@PostMapping()
	public Order create(@RequestBody JsonNode orderData) {
		return os.create(orderData);
	}
}
