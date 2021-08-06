package edu.poly.shop.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.poly.shop.domain.Account;
import edu.poly.shop.reponsitory.AccountReponsitory;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/register")
public class RegisterRestController {
@Autowired
AccountReponsitory accountReponsitory;
@PostMapping
public Account post(@RequestBody Account username) {
	accountReponsitory.save(username);
	return username;
}
@GetMapping
public List<Account> getAll(Model model) {
	return accountReponsitory.findAll();
}
}
