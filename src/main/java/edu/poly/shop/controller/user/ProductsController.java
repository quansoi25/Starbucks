package edu.poly.shop.controller.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.poly.shop.bean.CategoryDto;
import edu.poly.shop.bean.ProductDto;
import edu.poly.shop.domain.Category;
import edu.poly.shop.domain.Product;
import edu.poly.shop.service.CategoryService;
import edu.poly.shop.service.ProductService;

@Controller
@RequestMapping("user")
public class ProductsController {
	@Autowired
	ProductService ps;
	@Autowired
	CategoryService cs;
	@RequestMapping("")
	public String page(Model model) {
		return "user/page";
	}
	@RequestMapping("menu")
	public String menu(Model model) {
		List<Product> list=ps.findAll();
		model.addAttribute("items", list);
		return "user/index";
	}
	@RequestMapping("detail/{productId}")
	public ModelAndView detail(Model model,@PathVariable("productId")long productId) {
		Optional<Product> opt=ps.findById(productId);
		ProductDto dto=new ProductDto();
		if(opt.isPresent()) {
			Product entity=opt.get();
			BeanUtils.copyProperties(entity, dto);
			dto.setNameC(entity.getCategory().getName());
			model.addAttribute("item",dto);
			return new ModelAndView ("user/detail");
		}
		return null;
//		Product item=ps.findById(productId).get();
//		model.addAttribute("item", item);
//		return("user/detail");
	}
	@RequestMapping("view")
	public String viewcart() {
		return ("user/cart/view");
	}
}
