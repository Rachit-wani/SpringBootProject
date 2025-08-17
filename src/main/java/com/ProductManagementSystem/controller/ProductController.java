package com.ProductManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ProductManagementSystem.JPA.ProductJPA;
import com.ProductManagementSystem.entity.Product;
import com.ProductManagementSystem.service.ProductService;
import com.ProductManagementSystem.util.ResponseStructure;

@RestController
public class ProductController {
	
	@Autowired
private	ProductService pservice;
	@Autowired
	ProductJPA pjpa;
	
	
	@PostMapping("/create")
	public ResponseEntity<ResponseStructure<Product>> savedata(@RequestBody Product p)
	{
		return pservice.adddata(p);
	}
	
	@GetMapping("/findall")
	public List<Product> findall()
	{
		return pservice.Findall();
	}
	
	@GetMapping("/getid/{id}")
	public ResponseEntity<ResponseStructure<Product>> getbyid(@PathVariable    int id)
	{
		return pservice.getId(id);
	}
	

	@DeleteMapping("/deleteByid/{id}")
	public ResponseEntity<ResponseStructure<Product>> Deleteid(@PathVariable  int id)
	{
		return pservice.deleteId(id);
	}

	
//	@GetMapping("/Sort")
//	public List<Product> Sort()
//	{
//		return pservice.SortByName();
//	}
	
	@GetMapping("/byname/{name}")
	public List<Product>  GetByname(@PathVariable   String name)
	{
		return pservice.Fbyname(name);
	}
	
	@GetMapping("/sortnameasc")
	public List<Product> sortbyname()
	{
		return pservice.Bynameasc();
	}
	
	@GetMapping("/sortnamedsc")
	public List<Product> sortnyNameDsc()
	{
		return pservice.Bynamedsc();
	}
	
	@GetMapping("/bytype/{type}")
	public List<Product>  Bytype( @PathVariable   String type)
	{
		return pservice.Bytype(type);
	}
	
	
	@GetMapping("/sorttypeasc")
	public List<Product> sortbyType()
	{
		return pservice.Bytypeasc();
	}
	
	@GetMapping("/sorttypedsc")
	public List<Product> sortbyTypec()
	{
		return pservice.Bytypedsc();
	}  
	
	@GetMapping("/pagegetall/{page}/{size}")
	public Page<Product> getHosp(@PathVariable int  page,  @PathVariable   int size)
	{
		PageRequest pageable= PageRequest.of(page, size);
		return pjpa.findAll(pageable);
	}
	
	
	
	
}
