package edu.poly.shop.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.poly.shop.domain.Authorities;
import edu.poly.shop.reponsitory.AuthoritiesReponsitory;
import edu.poly.shop.service.AuthoritiesService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/authorities")
public class AuthoritiesRestController {
	@Autowired
	AuthoritiesService authoritiesService;
	@Autowired
	AuthoritiesReponsitory ar;
	@GetMapping
	public List<Authorities> finAll(@RequestParam("admin") Optional<Boolean>admin){
		if(admin.orElse(false)) {
			return authoritiesService.finAuthoritiesOfAdministrators();
		}
		return authoritiesService.findAll();
	}
//	@PostMapping
//	public Authorities post(@RequestBody Authorities auth) {
//		return authoritiesService.create(auth);
//	}
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Integer id) {
		ar.deleteById(id);
	}
	@PostMapping
	public Authorities post1(@RequestBody Authorities auth) {
		ar.save(auth);
		return auth;
	}
	@GetMapping("{id}")
	public Authorities getOne(@PathVariable("id") Integer id) {
		return ar.findById(id).get();
	}
}
