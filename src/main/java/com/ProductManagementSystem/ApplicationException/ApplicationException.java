package com.ProductManagementSystem.ApplicationException;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ProductManagementSystem.Exception.IdNotPresent;
import com.ProductManagementSystem.entity.Product;
import com.ProductManagementSystem.util.ResponseStructure;

@RestControllerAdvice
public class ApplicationException {
	
	@ExceptionHandler(IdNotPresent.class )
	public ResponseEntity<ResponseStructure<Product>> IdNotPresen(IdNotPresent obj)
	{
		 ResponseStructure<Product> res = new ResponseStructure<>();
		    res.setLocalDateTime(LocalDateTime.now());
		    res.setMessage(obj.getMessage());
		    res.setStatuscode(HttpStatus.NOT_FOUND.value());

		    return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);

		
		
	}
	}

