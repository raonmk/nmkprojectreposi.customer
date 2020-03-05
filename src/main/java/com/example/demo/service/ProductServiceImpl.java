package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Product;
import com.example.demo.model.ProductDto;
import com.example.demo.repository.ProductRepository;

@Component
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public List<Product> getAllProducts() {

		return productRepository.findAll();
	}

	@Override
	public Product getProductById(Long id) {
		Optional<Product> product = productRepository.findById(id);
		if (product.isPresent()) {
			return product.get();
		}

		else {
			throw new EntityExistsException("product not found with given id");
		}

	}

	@Override
	public void deleteProductById(Long id) {
		Optional<Product> product = productRepository.findById(id);
		if (product.isPresent()) {

			Product prod = product.get();
			productRepository.deleteById(prod.getId());
		}

		else {
			throw new EntityExistsException("no product found with the given id to delete");
		}
	}

	@Override
	public Product saveProduct(Product product) {

		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(Product productupdate, Long id) {

		Optional<Product> product = productRepository.findById(id);
		if (product.isPresent()) {

			Product prod = product.get();

			prod.setProductName(productupdate.getProductName());
			prod.setBatchName(productupdate.getBatchName());
			prod.setProductNo(productupdate.getProductNo());
			prod.setId(productupdate.getId());

			return productRepository.save(prod);
		} else {

			throw new EntityExistsException("Product not available with the given id");
		}
	}

//*********************************************************//Assingnment//*************************************//

	@Override
	public Product getProductByname(ProductDto productDto) {

		Optional<Product> product = productRepository.findProductByName(productDto.getName());

		if (product.isPresent()) {

			return product.get();
		} else {

			throw new EntityExistsException("product name not found");

		}

	}

	@Override
	public Product getProductByName(String name) {
		Optional<Product> product = productRepository.findProductByName(name);
		if (product.isPresent()) {

			return product.get();
		} else {

			throw new EntityExistsException("Product name not found");
		}
	}

	@Override
	public Product updateProductByName(Product name) {

		return productRepository.save(name);
	}

	@Override
	public void deleteProductByName(String name) {

		Optional<Product> product = productRepository.findProductByName(name);
		if (product.isPresent()) {

			long id = product.get().getId();
			productRepository.deleteById(id);
		} else {

			throw new EntityExistsException("record not found");
		}
	}

}
