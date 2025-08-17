package com.ProductManagementSystem.service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springdoc.core.converters.models.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.ProductManagementSystem.Exception.IdNotPresent;
import com.ProductManagementSystem.JPA.ProductJPA;
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
	
	
	public List<Product> Findall()
	{
		return pdao.Findall();
		}
	
	
	public  ResponseEntity<ResponseStructure<Product>> getId(int id)
	{
		ResponseStructure<Product> rs= new ResponseStructure<Product>();
		 if(pdao.GetId(id)!=null)
		 {
			 rs.setData(pdao.GetId(id));
			 rs.setLocalDateTime(LocalDateTime.now());
			 rs.setMessage("data fetched");
			 rs.setStatuscode(HttpStatus.FOUND.value());
			 return new ResponseEntity<ResponseStructure<Product>>(rs,HttpStatus.FOUND);
		 }
		 else
		 {
			 throw new IdNotPresent();
		 }
		
	}
	
	public ResponseEntity<ResponseStructure<Product>> deleteId(int id)
	{
		ResponseStructure<Product> rs= new ResponseStructure<Product>();
		Product pro=  pdao.GetId(id);
		if(pro!=null)
		{
			pdao.deleteid(id);
			 rs.setData(pdao.GetId(id));
			 rs.setLocalDateTime(LocalDateTime.now());
			 rs.setMessage("data fetched and deleted");
			 rs.setStatuscode(HttpStatus.FOUND.value());
			 
			 return new ResponseEntity<ResponseStructure<Product>>(rs,HttpStatus.FOUND);
		}
		else
		{
			
			 throw new IdNotPresent();
			
		}
		
	}
//	public List<Product> SortByName()
//	{
//		return pdao.SortByname();
//	}
	
	public List<Product> Fbyname(String name)
	{
		return pdao.byname(name);
	}
	
	
	public List<Product> Bynameasc()
	{
		List<Product> p =  pdao.Findall();
		return p.stream().sorted(Comparator.comparing(Product::getName)).collect(Collectors.toList());
				
	}
	
	public List<Product> Bynamedsc()
	{
		List<Product> p= pdao.Findall();
		return p.stream().sorted(Comparator.comparing(Product::getName).reversed()).collect(Collectors.toList());
	}
	
	public List<Product>  Bytype(String type)
	{
		return pdao.bytype(type);
	}
	
	public List<Product> Bytypeasc()
	{
		List<Product> p =  pdao.Findall();
		return p.stream().sorted(Comparator.comparing(Product::getType)).collect(Collectors.toList());
				
	}
	
	public List<Product> Bytypedsc()
	{
		List<Product> p= pdao.Findall();
		return p.stream().sorted(Comparator.comparing(Product::getType).reversed()).collect(Collectors.toList());
	}
	

//	public Page<Product> getPro(@PathVariable int page, int size)
//	{
//		PageRequest page1= PageRequest.of(page, size);
//		return pdao.Findall(page1);
//	}
	
	
}
