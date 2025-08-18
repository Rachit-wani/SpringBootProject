package com.ProductManagementSystem.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ProductManagementSystem.dao.CategoryDao;
import com.ProductManagementSystem.entity.Category;
import com.ProductManagementSystem.util.ResponseStructure;

@Service
public class CategoryService {
	
@Autowired
private	CategoryDao cdao;


	
public ResponseEntity<ResponseStructure<Category>> saved(Category c)
{
	Category ca= cdao.Savedata(c);
	
	ResponseStructure<Category> cr= new ResponseStructure<Category>();
	if(ca!=null)
	{
		cr.setData(ca);
		cr.setLocalDateTime(LocalDateTime.now());
		cr.setMessage("Data Saved");
		cr.setStatuscode(HttpStatus.CREATED.value());
		
	return	new ResponseEntity<ResponseStructure<Category>>(cr, HttpStatus.CREATED);
	}
	else
	{
		cr.setData(null);
		cr.setLocalDateTime(LocalDateTime.now());
		cr.setMessage("Data Saved");
		cr.setStatuscode(HttpStatus.NOT_ACCEPTABLE.value());
		
	return	new ResponseEntity<ResponseStructure<Category>>(cr, HttpStatus.NOT_ACCEPTABLE);
	}
	
	
}



public List<Category> callall()
{
	return cdao.cateAll();
}


public ResponseEntity<ResponseStructure<Category>> getid(int id)
{
Category ca= cdao.getbyid(id);
	
	ResponseStructure<Category> cr= new ResponseStructure<Category>();
	if(ca!=null)
	{
		cr.setData(ca);
		cr.setLocalDateTime(LocalDateTime.now());
		cr.setMessage("Data fetched");
		cr.setStatuscode(HttpStatus.FOUND.value());
		
	return	new ResponseEntity<ResponseStructure<Category>>(cr, HttpStatus.FOUND);
	}
	else
	{
		cr.setData(null);
		cr.setLocalDateTime(LocalDateTime.now());
		cr.setMessage("Data not fetched");
		cr.setStatuscode(HttpStatus.NOT_FOUND.value());
		
	return	new ResponseEntity<ResponseStructure<Category>>(cr, HttpStatus.NOT_FOUND);
	}
}

public String deleteCategory(int id) {
//    boolean deleted = cdao.deleteid(id);

    if (cdao.deleteid(id)) {
        return "Category with ID " + id + " deleted successfully.";
    } else {
        return "Category with ID " + id + " not found.";
    }
}

public List<Category> SortAsc( )
{
	return cdao.Sortasc("name");
}
public List<Category> SortDsc( )
{
	return cdao.Sortdsc("name");
}



//public long countbyid(int id)
//{
//	return cdao.countproductbyid(id);
//}
}
