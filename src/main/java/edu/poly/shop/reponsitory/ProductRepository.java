package edu.poly.shop.reponsitory;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.poly.shop.domain.Category;
import edu.poly.shop.domain.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{ 
	@Query("SELECT o FROM Product o WHERE o.category.categoryId = ?1")
	List<Product> findByCategoryHome(String categoryId);
	List<Product> findByNameContaining(String name); 
	
}

