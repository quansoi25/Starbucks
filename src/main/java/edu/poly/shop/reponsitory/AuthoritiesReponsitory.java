package edu.poly.shop.reponsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.poly.shop.domain.Account;
import edu.poly.shop.domain.Authorities;
@Repository
public interface AuthoritiesReponsitory  extends JpaRepository<Authorities, Integer>{
	@Query("SELECT DISTINCT a FROM Authorities a Where a.account IN ?1")
	List<Authorities> authoritiesOf(List<Account> accounts);

}
