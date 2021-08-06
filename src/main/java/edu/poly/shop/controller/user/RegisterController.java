package edu.poly.shop.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/security")
public class RegisterController {
	@RequestMapping("register")
	public String login(Model model) {
		model.addAttribute("message","Login here!!!");
		return "user/security/register";
	}
}
