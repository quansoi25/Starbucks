package edu.poly.shop.controller.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.poly.shop.service.OrderService;
import edu.poly.shop.service.ProductService;

@Controller
@RequestMapping("order")
public class OrderController {
	@Autowired
	OrderService os;
	@Autowired
	ProductService ps;
	@RequestMapping("checkout")
	public String checkout(){
		return"user/order/checkout";
	}
	@RequestMapping("list")
	public String list(Model model,HttpServletRequest request){
		String username=request.getRemoteUser();
		model.addAttribute("orders",os.findByUsername(username));
		return"user/order/list";
	}
	@RequestMapping("detail/{Id}")
	public String detail(@PathVariable("Id")Long Id,Model model ){
		model.addAttribute("order",os.findById(Id));
		return"user/order/detail";
	}
}
