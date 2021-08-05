package edu.poly.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.poly.shop.domain.Account;
import edu.poly.shop.domain.Authorities;
import edu.poly.shop.reponsitory.AccountReponsitory;
import edu.poly.shop.reponsitory.AuthoritiesReponsitory;
import edu.poly.shop.service.AuthoritiesService;
@Service
public class AuthoritiesServiceImpl implements AuthoritiesService{

@Override
public List<Authorities> findAll() {
		return authoritiesReponsitory.findAll();
	}

@Autowired
AuthoritiesReponsitory authoritiesReponsitory;
@Autowired
AccountReponsitory ar;

@Override
public List<Authorities> finAuthoritiesOfAdministrators() {
	List<Account> accounts=ar.getAdministrators();
	return authoritiesReponsitory.authoritiesOf(accounts);
}

@Override
public Authorities create(Authorities auth) {
	return authoritiesReponsitory.save(auth);
}

@Override
public void delete(Integer id) {
	authoritiesReponsitory.deleteById(id);
	
}

}
