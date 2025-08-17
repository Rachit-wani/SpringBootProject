package com.ProductManagementSystem.Exception;

public class IdNotPresent extends RuntimeException{
	
	
	@Override
	public String getMessage()
	{
		return "Id not present";
	}

}
