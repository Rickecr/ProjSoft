package com.psoft.lab02.service;

import org.springframework.stereotype.Service;

import com.psoft.lab02.dao.ProductDAO;
import com.psoft.lab02.model.Product;

@Service
public class ProductService {

	private final ProductDAO productDAO;
	
	public ProductService(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}
	
	public Product create(Product product) {
		return productDAO.save(product);
	}
	
	public Product update(Product productToUpdate) {
		Product product = this.productDAO.findById(productToUpdate.getId());
		
		if (product == null) {
			// Lançar exceção.
		}
		
		return this.productDAO.save(productToUpdate);
	}
	
	public void delete(long id) {
		this.productDAO.delete(id);
	}
	
	public Product findyById(long id) {
		return this.productDAO.findById(id);
	}
	
}
