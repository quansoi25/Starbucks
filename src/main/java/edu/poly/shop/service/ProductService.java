package edu.poly.shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import edu.poly.shop.domain.Product;

public interface ProductService {

	<S extends Product> S saveAndFlush(S arg0);

	<S extends Product> List<S> saveAllAndFlush(Iterable<S> arg0);

	<S extends Product> List<S> saveAll(Iterable<S> arg0);

	<S extends Product> S save(S arg0);

	Product getOne(Long arg0);

	Product getById(Long arg0);

	void flush();

	<S extends Product> Optional<S> findOne(Example<S> arg0);

	Optional<Product> findById(Long arg0);

	List<Product> findAllById(Iterable<Long> arg0);

	List<Product> findAll(Sort arg0);

	Page<Product> findAll(Pageable arg0);

	<S extends Product> List<S> findAll(Example<S> arg0);

	<S extends Product> List<S> findAll(Example<S> arg0, Sort arg1);

	<S extends Product> Page<S> findAll(Example<S> arg0, Pageable arg1);

	List<Product> findAll();

	boolean existsById(Long arg0);

	<S extends Product> boolean exists(Example<S> arg0);

	void deleteInBatch(Iterable<Product> entities);

	void deleteById(Long arg0);

	void deleteAllInBatch(Iterable<Product> arg0);

	void deleteAllInBatch();

	void deleteAllByIdInBatch(Iterable<Long> arg0);

	void deleteAllById(Iterable<? extends Long> arg0);

	void deleteAll(Iterable<? extends Product> arg0);

	void deleteAll();

	void delete(Product arg0);

	<S extends Product> long count(Example<S> arg0);

	long count();

	Product findById1(Long productId);





}
