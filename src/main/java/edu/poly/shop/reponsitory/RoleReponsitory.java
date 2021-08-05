package edu.poly.shop.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.poly.shop.domain.Role;
@Repository
public interface RoleReponsitory extends JpaRepository<Role,String> {

}
