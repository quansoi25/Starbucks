package edu.poly.shop.controller.user;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/security")
public class SecurityController {
	@RequestMapping("login/form")
	public String login(Model model) {
		model.addAttribute("message","Login here!!!");
		return "user/security/login";
	}
	@RequestMapping("login/form/success")
	public String loginSuccess(Model model) {
		model.addAttribute("message","Login Success!!");
		return "user/page";
	}
	@RequestMapping("login/form/error")
	public String loginFail(Model model) {
		model.addAttribute("message","Login Fail!!");
		return "user/security/login";
	}
	@RequestMapping("unauthoried")
	public String unauthoried(Model model) {
		model.addAttribute("message","You not have access!!!");
		return "user/security/login";
	}
	@RequestMapping("logoff/success")
	public String logoffSuccess(Model model) {
		model.addAttribute("message","Sign out success!!!");
		return "user/security/login";
	}
	
	@RequestMapping("oauth2/login/success")
	public String success(OAuth2AuthenticationToken oauth2) {
		return"user/page";
	}
}
