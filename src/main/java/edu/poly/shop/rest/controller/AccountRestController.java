package edu.poly.shop.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.poly.shop.domain.Account;
import edu.poly.shop.reponsitory.AccountReponsitory;
import edu.poly.shop.service.AccountService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/accounts")
public class AccountRestController {
@Autowired
AccountService accountService;
@Autowired
AccountReponsitory ar;
@GetMapping
public List<Account> getAll(){
	return accountService.findAll();
}
@GetMapping("{username}")
public List<Account> getOne(@PathVariable("username") String username){
	return ar.findByUsername(username);
}
}
