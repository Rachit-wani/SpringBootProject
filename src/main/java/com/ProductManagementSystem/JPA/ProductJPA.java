package com.ProductManagementSystem.JPA;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProductManagementSystem.entity.Product;

public interface ProductJPA extends JpaRepository<Product, Integer>{

}
