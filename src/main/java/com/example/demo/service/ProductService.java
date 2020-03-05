package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Product;
import com.example.demo.model.ProductDto;

public interface ProductService {
	
	List<Product> getAllProducts();
	
	Product getProductById(Long id);
	
	void deleteProductById(Long id);
	
	Product saveProduct(Product product);
	
	Product updateProduct(Product product,Long id);
	
	
	
	Product getProductByname(ProductDto productDto);
	
	Product getProductByName(String name);
	
	Product updateProductByName(Product product);
	
	void deleteProductByName(String name);
	
	
}
