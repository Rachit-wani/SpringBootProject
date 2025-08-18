package com.ProductManagementSystem.JPA;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProductManagementSystem.entity.Category;

public interface CategoryJPA extends JpaRepository<Category, Integer>{
	
	
	
//	
//public long countbycategoryid(int id);

}
