package com.ecom.Exception;

public class InvalidIdException extends Exception{
	
	private String message ;

     private InvalidIdException(String message) {
		System.out.println(message);
		
	}

	public String getMessage() {
		return message;
	}

	
	

}
