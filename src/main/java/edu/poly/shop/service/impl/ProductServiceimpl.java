package edu.poly.shop.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import edu.poly.shop.domain.Category;
import edu.poly.shop.domain.Product;
import edu.poly.shop.reponsitory.ProductRepository;
import edu.poly.shop.service.ProductService;

@Service
public class ProductServiceimpl implements ProductService{
@Override
public long count() {
		return productRepository.count();
	}

	@Override
	public <S extends Product> long count(Example<S> arg0) {
		return productRepository.count(arg0);
	}

	@Override
	public void delete(Product arg0) {
		productRepository.delete(arg0);
	}

	@Override
	public void deleteAll() {
		productRepository.deleteAll();
	}

	@Override
	public void deleteAll(Iterable<? extends Product> arg0) {
		productRepository.deleteAll(arg0);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> arg0) {
		productRepository.deleteAllById(arg0);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> arg0) {
		productRepository.deleteAllByIdInBatch(arg0);
	}

	@Override
	public void deleteAllInBatch() {
		productRepository.deleteAllInBatch();
	}

	@Override
	public void deleteAllInBatch(Iterable<Product> arg0) {
		productRepository.deleteAllInBatch(arg0);
	}

	@Override
	public void deleteById(Long arg0) {
		productRepository.deleteById(arg0);
	}
	@Override
	public Product findById1(Long productId) {
		return productRepository.findById(productId).get();
	}
	@Override
	public void deleteInBatch(Iterable<Product> entities) {
		productRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends Product> boolean exists(Example<S> arg0) {
		return productRepository.exists(arg0);
	}

	@Override
	public boolean existsById(Long arg0) {
		return productRepository.existsById(arg0);
	}

	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public <S extends Product> Page<S> findAll(Example<S> arg0, Pageable arg1) {
		return productRepository.findAll(arg0, arg1);
	}

	@Override
	public <S extends Product> List<S> findAll(Example<S> arg0, Sort arg1) {
		return productRepository.findAll(arg0, arg1);
	}

	@Override
	public <S extends Product> List<S> findAll(Example<S> arg0) {
		return productRepository.findAll(arg0);
	}

	@Override
	public Page<Product> findAll(Pageable arg0) {
		return productRepository.findAll(arg0);
	}

	@Override
	public List<Product> findAll(Sort arg0) {
		return productRepository.findAll(arg0);
	}

	@Override
	public List<Product> findAllById(Iterable<Long> arg0) {
		return productRepository.findAllById(arg0);
	}

	@Override
	public Optional<Product> findById(Long arg0) {
		return productRepository.findById(arg0);
	}

	@Override
	public <S extends Product> Optional<S> findOne(Example<S> arg0) {
		return productRepository.findOne(arg0);
	}

	@Override
	public void flush() {
		productRepository.flush();
	}

	@Override
	public Product getById(Long arg0) {
		return productRepository.getById(arg0);
	}

	@Override
	public Product getOne(Long arg0) {
		return productRepository.getOne(arg0);
	}

	@Override
	public <S extends Product> S save(S arg0) {
		return productRepository.save(arg0);
	}

	@Override
	public <S extends Product> List<S> saveAll(Iterable<S> arg0) {
		return productRepository.saveAll(arg0);
	}

	@Override
	public <S extends Product> List<S> saveAllAndFlush(Iterable<S> arg0) {
		return productRepository.saveAllAndFlush(arg0);
	}

	@Override
	public <S extends Product> S saveAndFlush(S arg0) {
		return productRepository.saveAndFlush(arg0);
	}
	
@Autowired
private ProductRepository productRepository;

}
