package edu.poly.shop.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.poly.shop.domain.Order;
import edu.poly.shop.domain.OrderDetail;
import edu.poly.shop.reponsitory.OrderDetailReponsitory;
import edu.poly.shop.reponsitory.OrderReponsitory;
import edu.poly.shop.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderReponsitory or;
	@Autowired
	OrderDetailReponsitory odr;

	@Override
	public Order create(JsonNode orderData) {
ObjectMapper mapper = new ObjectMapper();
		
		Order order = mapper.convertValue(orderData, Order.class);
		or.save(order);
		
		TypeReference<List<OrderDetail>> type = new TypeReference<List<OrderDetail>>() {};
		List<OrderDetail> details = mapper.convertValue(orderData.get("orderDetails"),type)
				.stream().peek(d -> d.setOrder(order)).collect(Collectors.toList());
		odr.saveAll(details);
		
		return order;
	}

	@Override
	public Order findById(Long Id) {

		return or.findById(Id).get();
	}


	@Override
	public List<Order> findByUsername(String username) {
		return or.findByUsername(username);
	}

}
