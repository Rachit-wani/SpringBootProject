package com.ProductManagementSystem.dao;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springdoc.core.converters.models.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import com.ProductManagementSystem.JPA.CategoryJPA;
import com.ProductManagementSystem.JPA.ProductJPA;
import com.ProductManagementSystem.entity.Category;
import com.ProductManagementSystem.entity.Product;

@Repository
public class ProductDao {
	
@Autowired
private	ProductJPA pjpa;

@Autowired
private CategoryJPA cjpa;



	
	
	public ProductDao(ProductJPA pjpa, CategoryJPA cjpa) {
	this.pjpa = pjpa;
	this.cjpa = cjpa;
}

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
	
	
	public void deleteall()
	{
		pjpa.deleteAll();
	}
	
//	public Product saveProduct(Product product ,int categoryid)
//	{
//		Category cate= cjpa.findById(categoryid).orElse(null);
//		
//		if(cate!=null)
//		{
//			product.setCategory(cate);
//		}
//		return pjpa.save(product);
//	}
	public Category cfindbyid(int id)
	{
		return cjpa.findById(id).orElse(null);
	}
	
}
