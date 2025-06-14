package com.furkanyanik.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.furkanyanik.entity.Product;
import com.furkanyanik.service.ProductService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/product")

public class ProductController {
	@Autowired
	private ProductService productService;
	
	
@PostMapping("/save")
public Product saveProduct(@RequestBody Product product) {
  
return	productService.saveProduct(product); 
}
@PostMapping("/search/product")
public List<Product> findProductExample(@RequestBody @Valid Product product){
	return productService.findProductExample(product);
	
}
	
@GetMapping("/search/example")
public ResponseEntity<List<Product>> findProductWith(
		@RequestParam(required = false) String category ,  @RequestParam(required = false) String brand ) {
	List<Product> product = productService.findProductWith(category, brand);
	return ResponseEntity.ok(product);

}

	
	

	
	

}
