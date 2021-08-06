package edu.poly.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.poly.shop.domain.Account;
import edu.poly.shop.domain.Category;
import edu.poly.shop.domain.Role;
import edu.poly.shop.reponsitory.AccountReponsitory;
import edu.poly.shop.reponsitory.RoleReponsitory;

@Controller
@RequestMapping("admin/role")
public class RoleController {
	@Autowired
	AccountReponsitory accountReponsitory;
	@RequestMapping("")
	public String add(Model model) {
		return "admin/role/list";
	}
	@GetMapping("search")
	public String sreach(ModelMap model,@RequestParam (name="name",required = false) String username) {
		List<Account>list=null;
		if(StringUtils.hasText(username)) {
			list=accountReponsitory.findByUsername(username);			
		}else {
			list=accountReponsitory.findAll();
		}
		model.addAttribute("role", list);
		return"admin/role/search";
	}
}
