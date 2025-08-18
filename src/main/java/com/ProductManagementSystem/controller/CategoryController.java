package com.ProductManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProductManagementSystem.dao.CategoryDao;
import com.ProductManagementSystem.entity.Category;
import com.ProductManagementSystem.service.CategoryService;
import com.ProductManagementSystem.util.ResponseStructure;


@RequestMapping("/Category")
@RestController
public class CategoryController {
	
	
	@Autowired
	private CategoryService cservice;
	
	@PostMapping("/Addpro")
	public ResponseEntity<ResponseStructure<Category>> SaveCat(@RequestBody  Category c)
	{
		return cservice.saved(c);
	}
	
	@GetMapping("/CallAll")
	public List<Category>  Findall()
	{
		return cservice.callall();
	}
	
	@GetMapping("/getid/{id}")
	public ResponseEntity<ResponseStructure<Category>> getid(@PathVariable     int id)
	{
		return cservice.getid(id);
	}
	
	@DeleteMapping("/category/{id}")
    public String deleteCategory(@PathVariable int id) {
        return cservice.deleteCategory(id);
    }
	
	@GetMapping("/getnameasc")
	public List<Category>  SortAllAscname()
	{
		return cservice.SortAsc();
	}
	
	@GetMapping("/getnamedsc")
	public List<Category>  SortAllDscname()
	{
		return cservice.SortDsc();
	}
	
//@GetMapping("/countbyid/{id}")	
//public long countbyid(@PathVariable  int id)
//{
//	return cservice.countbyid(id);
//}
	
	
	
	

}
