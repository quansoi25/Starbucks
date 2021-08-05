package edu.poly.shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import edu.poly.shop.domain.Category;

@Service
public interface CategoryService {

	<S extends Category> S saveAndFlush(S arg0);

	<S extends Category> List<S> saveAllAndFlush(Iterable<S> arg0);

	<S extends Category> List<S> saveAll(Iterable<S> arg0);

	<S extends Category> S save(S arg0);

	Category getOne(Long arg0);

	Category getById(Long arg0);

	void flush();

	<S extends Category> Optional<S> findOne(Example<S> arg0);

	Optional<Category> findById(Long arg0);

	List<Category> findAllById(Iterable<Long> arg0);

	List<Category> findAll(Sort arg0);

	Page<Category> findAll(Pageable arg0);

	<S extends Category> List<S> findAll(Example<S> arg0);

	<S extends Category> List<S> findAll(Example<S> arg0, Sort arg1);

	<S extends Category> Page<S> findAll(Example<S> arg0, Pageable arg1);

	List<Category> findAll();

	boolean existsById(Long arg0);

	<S extends Category> boolean exists(Example<S> arg0);

	void deleteInBatch(Iterable<Category> entities);

	void deleteById(Long arg0);

	void deleteAllInBatch(Iterable<Category> arg0);

	void deleteAllInBatch();

	void deleteAllByIdInBatch(Iterable<Long> arg0);

	void deleteAllById(Iterable<? extends Long> arg0);

	void deleteAll(Iterable<? extends Category> arg0);

	void deleteAll();

	void delete(Category arg0);

	<S extends Category> long count(Example<S> arg0);

	long count();


	List<Category> findByName(String name);

	List<Category> findByNameContaining(String name);

	Page<Category> findByNameContaining(String name, Pageable pageable);



}
