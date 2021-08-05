package edu.poly.shop.rest.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import edu.poly.shop.domain.Product;
import edu.poly.shop.service.ProductService;


@CrossOrigin("*")
@RestController
@RequestMapping("/rest/products")
public class ProductRestController {
	@Autowired
	ProductService ps;

	@GetMapping("{productId}")
	public Product getOne(@PathVariable("productId") Long productId) {
		return ps.findById1(productId);
	}
}
