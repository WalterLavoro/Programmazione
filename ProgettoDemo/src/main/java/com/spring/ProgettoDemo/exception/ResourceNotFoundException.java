package com.spring.ProgettoDemo.exception;

public class ResourceNotFoundException extends RuntimeException {
	//Creata da gpt
	private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String message) {
        super(message);
    }
    
    public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s non trovato con %s: '%s'", resourceName, fieldName, fieldValue));
    }

}
