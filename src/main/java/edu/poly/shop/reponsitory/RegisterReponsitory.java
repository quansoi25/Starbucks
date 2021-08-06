package edu.poly.shop.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.poly.shop.domain.Account;

public interface RegisterReponsitory extends JpaRepository<Account,String>{

}
