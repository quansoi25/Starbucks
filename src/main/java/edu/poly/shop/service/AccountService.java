package edu.poly.shop.service;


import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import edu.poly.shop.domain.Account;

@Service
public interface AccountService {

	Account findById(String username);

	List<Account> findAll(Sort arg0);

	Page<Account> findAll(Pageable arg0);

	<S extends Account> List<S> findAll(Example<S> arg0);

	<S extends Account> List<S> findAll(Example<S> arg0, Sort arg1);

	<S extends Account> Page<S> findAll(Example<S> arg0, Pageable arg1);

	List<Account> findAll();

	List<Account> getAdministrators();

	
	
}
