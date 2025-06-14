package com.furkanyanik.service;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;

import static org.springframework.data.domain.ExampleMatcher.matching;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.furkanyanik.entity.Product;
import com.furkanyanik.repository.ProductRepository;



@Service
@Transactional(readOnly = true)
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	
	
	
	
	public Product saveProduct(Product product) {
	
		return	productRepository.save(product);
	}
	
	public List<Product> findProductExample(Product product){
		
		Example<Product> example=Example.of(product);
		
		return productRepository.findAll(example);
		
	}
	
	
	public List<Product> findProductWith(String category , String brand){
	Product product= Product.builder()
			.category(category)
			.brand(brand)
			.build();

	
	 ExampleMatcher matcher =matching()
             .withIgnoreCase()                          
             .withStringMatcher(StringMatcher.CONTAINING)
             .withIgnoreNullValues()                    
             .withMatcher("category", match -> match.exact()) 
             .withMatcher("brand", match -> match.contains());

			Example<Product> example=Example.of(product, matcher);
			
			return productRepository.findAll(example);
		
	}


	
	
	
	
	
	
			
	
	
}
	
	
	


