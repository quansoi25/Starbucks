package edu.poly.shop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.poly.shop.domain.Role;
@Service
public interface RoleService {

	List<Role> findAll();

}
