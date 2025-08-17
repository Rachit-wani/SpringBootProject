package com.ProductManagementSystem.dao;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springdoc.core.converters.models.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
	
	public List<Product> Findall()
	{
		return pjpa.findAll();
	}
	public Product GetId(int id)
	{
		return pjpa.findById(id).orElse(null);
	}

	public boolean deleteid(int id)
	{
		if(pjpa.existsById(id))
		{
			pjpa.deleteById(id);
			return true;
		}
		return false;
	}
	
	public List<Product> byname(String name)
	{
		return pjpa.FindbyName(name);
	}
	
	public List<Product> Sortbyname()
	{
		return pjpa.findAll();
	}
	
	public List<Product> bytype(String name)
	{
		return pjpa.FindByType(name);
	}
	
	
}
