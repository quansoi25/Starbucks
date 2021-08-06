package edu.poly.shop.reponsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import edu.poly.shop.domain.Account;

public interface AccountReponsitory extends JpaRepository<Account,String> {
	@Query("SELECT DISTINCT ar.account FROM Authorities ar WHERE ar.role.id IN('ADMIN','STAFF','GUEST')")
	List<Account> getAdministrators();

	List<Account> findByUsername(String username);
}
