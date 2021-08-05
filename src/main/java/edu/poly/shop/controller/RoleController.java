package edu.poly.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/role")
public class RoleController {
	@RequestMapping("")
	public String add(Model model) {
		return "admin/role/addOrEdit";
	}
}
