package com.psoft.lab03.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.psoft.lab03.model.Product;

public interface ProductDAO<T, ID extends Serializable> extends JpaRepository<Product, Long> {
	
	Product save(Product product);
	
	Product findById(long id);
	
}
