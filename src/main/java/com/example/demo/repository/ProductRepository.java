package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	@Query(value = "select * from product p where p.product_name=?", nativeQuery = true)
	Optional<Product> findProductByName(String name);

	@Query(value = "select * from product p where p.product_name=?", nativeQuery = true)
	Optional<Product> findProductByNamePath(String name);

	@Query(value = "select * from product p where p.product_name=?", nativeQuery = true)
	Optional<Product> updateProductByName(String name);

}
