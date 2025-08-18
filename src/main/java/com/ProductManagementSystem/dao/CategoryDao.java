package com.ProductManagementSystem.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.ProductManagementSystem.JPA.CategoryJPA;
import com.ProductManagementSystem.entity.Category;

@Repository
public class CategoryDao {
	
	@Autowired
	private CategoryJPA cjpa;
	public Category Savedata(Category c)
	{
		return  cjpa.save(c);
	}
	
	public List<Category> cateAll()
	{
		return cjpa.findAll();
	}
	
	public Category getbyid(int id)
	{
		return cjpa.findById(id).orElse(null);
	}
	
	public boolean deleteid(int id)
	{
		if(cjpa.existsById(id)) {
			cjpa.deleteById(id);
			return true;
		}
		return false;
	}
	
	public List<Category> Sortasc(String name)
	{
		return cjpa.findAll(Sort.by(Sort.Direction.ASC,name));
	}
	
	public List<Category>  Sortdsc(String name)
	{
		return cjpa.findAll(Sort.by(Sort.Direction.DESC,name));
	}
//  public Long countproductbyid(int id)
//  {
//	  return cjpa.countbycategoryid(id);
//  }
//	
 }
