package com.ProductManagementSystem.JPA;

import java.util.List;

import org.springdoc.core.converters.models.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ProductManagementSystem.entity.Product;

public interface ProductJPA extends JpaRepository<Product, Integer>{
	
	@Query("Select h from Product h where h.name=?1")
	public List<Product> FindbyName(String name);
	

	@Query("Select h from Product h where h.type=?1")
	public List<Product > FindByType(String name);


	

}
