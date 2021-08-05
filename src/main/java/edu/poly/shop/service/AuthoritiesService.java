package edu.poly.shop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.poly.shop.domain.Authorities;

@Service
public interface AuthoritiesService {

	List<Authorities> finAuthoritiesOfAdministrators();

	List<Authorities> findAll();


	Authorities create(Authorities auth);

	void delete(Integer id);

}
