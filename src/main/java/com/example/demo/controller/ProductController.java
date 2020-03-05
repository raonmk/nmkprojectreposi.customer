package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.model.ProductDto;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/product/v1")
public class ProductController {
	@Autowired
	ProductService productService;

	@GetMapping("/product/getAll")
	public List<Product> getAllProducts() {
		
		return productService.getAllProducts();

	}

	@GetMapping("/products/{id}")
	public Product getProductById(@PathVariable("id") Long id) {
		
		return productService.getProductById(id);

	}

	@DeleteMapping("/product/deleteById/{id}")
	public String deleteProductById(@PathVariable("id") Long id) {
		
		productService.deleteProductById(id);
		return "product deleted successfully";

	}
	
	@PostMapping("/productsave")
	public Product saveProduct(@RequestBody Product product) {
		
		return productService.saveProduct(product);
		
	}
	
	@PutMapping("/productupdate/{id}")
	public Product updateProduct(@RequestBody Product product,@PathVariable("id") Long id) {
		
		return productService.updateProduct(product, id);
		
	}
	
	
      //*****************************************//Assignments//***************************************//  
	
	@PostMapping("/getByName")
	public Product getByProductByName(@RequestBody ProductDto productDto) {
		
		return productService.getProductByname(productDto);
		
		
	}
	
	@PostMapping("/getByNamerequestparam")
	public Product getByProductName(@RequestParam String name) {
		
		return productService.getProductByName(name);
		
	}
	
	
	@PutMapping("/updateByName/{name}")
	public Product updateProductByName(@PathVariable("name") String name,@RequestBody Product product) {
		
		return productService.updateProductByName(product);
		
	}
	
	
	@DeleteMapping("/deletebyName")
	public void deleteProductByName(@RequestParam String name) {
		
		productService.deleteProductByName(name);
		
		
	}
	
	
	
}
