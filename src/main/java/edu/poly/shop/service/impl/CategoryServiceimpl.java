package edu.poly.shop.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import edu.poly.shop.domain.Category;
import edu.poly.shop.reponsitory.CategoryReponsitory;
import edu.poly.shop.service.CategoryService;

@Service
public class CategoryServiceimpl  implements CategoryService{
@Override
public long count() {
		return cr.count();
	}
	@Override
	public <S extends Category> long count(Example<S> arg0) {
		return cr.count(arg0);
	}
	@Override
	public void delete(Category arg0) {
		cr.delete(arg0);
	}
	@Override
	public void deleteAll() {
		cr.deleteAll();
	}
	@Override
	public void deleteAll(Iterable<? extends Category> arg0) {
		cr.deleteAll(arg0);
	}
	@Override
	public void deleteAllById(Iterable<? extends Long> arg0) {
		cr.deleteAllById(arg0);
	}
	@Override
	public void deleteAllByIdInBatch(Iterable<Long> arg0) {
		cr.deleteAllByIdInBatch(arg0);
	}
	@Override
	public void deleteAllInBatch() {
		cr.deleteAllInBatch();
	}
	@Override
	public void deleteAllInBatch(Iterable<Category> arg0) {
		cr.deleteAllInBatch(arg0);
	}
	@Override
	public void deleteById(Long arg0) {
		cr.deleteById(arg0);
	}
	@Override
	public void deleteInBatch(Iterable<Category> entities) {
		cr.deleteInBatch(entities);
	}
	@Override
	public <S extends Category> boolean exists(Example<S> arg0) {
		return cr.exists(arg0);
	}
	@Override
	public boolean existsById(Long arg0) {
		return cr.existsById(arg0);
	}
	@Override
	public List<Category> findAll() {
		return cr.findAll();
	}
	@Override
	public <S extends Category> Page<S> findAll(Example<S> arg0, Pageable arg1) {
		return cr.findAll(arg0, arg1);
	}
	@Override
	public <S extends Category> List<S> findAll(Example<S> arg0, Sort arg1) {
		return cr.findAll(arg0, arg1);
	}
	@Override
	public <S extends Category> List<S> findAll(Example<S> arg0) {
		return cr.findAll(arg0);
	}
	@Override
	public Page<Category> findAll(Pageable arg0) {
		return cr.findAll(arg0);
	}
	@Override
	public List<Category> findAll(Sort arg0) {
		return cr.findAll(arg0);
	}
	@Override
	public List<Category> findAllById(Iterable<Long> arg0) {
		return cr.findAllById(arg0);
	}
	@Override
	public Optional<Category> findById(Long arg0) {
		return cr.findById(arg0);
	}
	@Override
	public <S extends Category> Optional<S> findOne(Example<S> arg0) {
		return cr.findOne(arg0);
	}
	@Override
	public void flush() {
		cr.flush();
	}
	@Override
	public Category getById(Long arg0) {
		return cr.getById(arg0);
	}
	@Override
	public Category getOne(Long arg0) {
		return cr.getOne(arg0);
	}
	@Override
	public <S extends Category> S save(S arg0) {
		return cr.save(arg0);
	}
	@Override
	public <S extends Category> List<S> saveAll(Iterable<S> arg0) {
		return cr.saveAll(arg0);
	}
	@Override
	public <S extends Category> List<S> saveAllAndFlush(Iterable<S> arg0) {
		return cr.saveAllAndFlush(arg0);
	}
	@Override
	public <S extends Category> S saveAndFlush(S arg0) {
		return cr.saveAndFlush(arg0);
	}
CategoryReponsitory cr;
public CategoryServiceimpl(CategoryReponsitory cr) {
	this.cr = cr;
}
@Override
public Page<Category> findByNameContaining(String name, Pageable pageable) {
	return cr.findByNameContaining(name, pageable);
}

@Override
public List<Category> findByNameContaining(String name) {
	return cr.findByNameContaining(name);
}
}
