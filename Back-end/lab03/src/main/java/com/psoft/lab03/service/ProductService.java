package com.psoft.lab03.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.psoft.lab03.Exception.Product.ProductNotFoundException;
import com.psoft.lab03.dao.ProductDAO;
import com.psoft.lab03.model.Product;

@Service
public class ProductService {

	private final ProductDAO productDAO;
	
	public ProductService(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}
	
	public Product create(Product product) {
		return productDAO.save(product);
	}
	
	public Product update(Product productToUpdate) throws ProductNotFoundException {
		Product product = this.productDAO.findById(productToUpdate.getId());
		
		if (product == null) {
			throw new ProductNotFoundException("Produto não existe para ser atualizado!");
		}
		
		return this.productDAO.save(productToUpdate);
	}
	
	public Product updatePartial(Product product) throws ProductNotFoundException {
		Product updatePartialProduct = this.productDAO.findById(product.getId());
		
		if (updatePartialProduct == null) {
			throw new ProductNotFoundException("Produto não encontrado!");
		}

		if (product.getName() != null) {
			updatePartialProduct.setName(product.getName());
		}
		if (product.getDescription() != null) {
			updatePartialProduct.setDescription(product.getDescription());
		}
		if (product.getPrice() > 0) {
			updatePartialProduct.setPrice(product.getPrice());
		}
		
		return this.productDAO.save(updatePartialProduct);
	}
 	
	public void delete(long id) {
		this.productDAO.deleteById(id);
	}
	
	public Product findyById(long id) {
		return this.productDAO.findById(id);
	}
	
	public List<Product> getAll() {
		return this.productDAO.findAll();
	}
	
}
