package com.ProductManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ProductManagementSystem.entity.Product;
import com.ProductManagementSystem.service.ProductService;
import com.ProductManagementSystem.util.ResponseStructure;

@RestController
public class ProductController {
	
	@Autowired
private	ProductService pservice;
	
	
	@PostMapping("/create")
	public ResponseEntity<ResponseStructure<Product>> savedata(@RequestBody Product p)
	{
		return pservice.adddata(p);
	}

}
