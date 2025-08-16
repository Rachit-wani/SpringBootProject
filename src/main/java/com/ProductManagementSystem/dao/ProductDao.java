package com.ProductManagementSystem.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ProductManagementSystem.JPA.ProductJPA;
import com.ProductManagementSystem.entity.Product;

@Repository
public class ProductDao {
	
@Autowired
private	ProductJPA pjpa;
	
	
	public Product Savepro(Product p)
	{
		return pjpa.save(p);
	}

}
