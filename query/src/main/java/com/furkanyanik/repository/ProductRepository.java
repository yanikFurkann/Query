package com.furkanyanik.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import com.furkanyanik.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> , QueryByExampleExecutor<Product>{



}
