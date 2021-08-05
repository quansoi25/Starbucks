package edu.poly.shop.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import edu.poly.shop.domain.Account;
import edu.poly.shop.reponsitory.AccountReponsitory;
import edu.poly.shop.service.AccountService;
@Service
public class AccountServiceimpl implements AccountService{
	@Override
	public List<Account> findAll() {
		return accountReponsitory.findAll();
	}
	@Override
	public <S extends Account> Page<S> findAll(Example<S> arg0, Pageable arg1) {
		return accountReponsitory.findAll(arg0, arg1);
	}
	@Override
	public <S extends Account> List<S> findAll(Example<S> arg0, Sort arg1) {
		return accountReponsitory.findAll(arg0, arg1);
	}
	@Override
	public <S extends Account> List<S> findAll(Example<S> arg0) {
		return accountReponsitory.findAll(arg0);
	}
	@Override
	public Page<Account> findAll(Pageable arg0) {
		return accountReponsitory.findAll(arg0);
	}
	@Override
	public List<Account> findAll(Sort arg0) {
		return accountReponsitory.findAll(arg0);
	}
	@Override
	public Account findById(String username) {
		return accountReponsitory.findById(username).get();
	}

	@Autowired
	AccountReponsitory accountReponsitory;
	public AccountServiceimpl(AccountReponsitory accountReponsitory) {
		this.accountReponsitory=accountReponsitory;
	}
	@Override
	public List<Account> getAdministrators() {
		return accountReponsitory.getAdministrators();
	}
	
}
