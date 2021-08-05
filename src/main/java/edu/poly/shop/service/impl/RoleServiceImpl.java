package edu.poly.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.poly.shop.domain.Role;
import edu.poly.shop.reponsitory.RoleReponsitory;
import edu.poly.shop.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService{
@Override
public List<Role> findAll() {
		return roleReponsitory.findAll();
	}

@Autowired
RoleReponsitory roleReponsitory;


}
