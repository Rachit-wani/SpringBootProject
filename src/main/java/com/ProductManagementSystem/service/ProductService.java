package com.ProductManagementSystem.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ProductManagementSystem.dao.ProductDao;
import com.ProductManagementSystem.entity.Product;
import com.ProductManagementSystem.util.ResponseStructure;


@Service
public class ProductService {
	
	@Autowired
private	ProductDao pdao;

	
	public ResponseEntity<ResponseStructure<Product>> adddata(Product h)
	{
		pdao.Savepro(h);
		
		ResponseStructure<Product> rs= new ResponseStructure<Product>();
		rs.setData(h);
		rs.setLocalDateTime(LocalDateTime.now());
		rs.setMessage("Data added");
		rs.setStatuscode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Product>>(rs,HttpStatus.ACCEPTED);
	}
	
}
