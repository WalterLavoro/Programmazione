package com.spring.ProgettoDemo.exception;

public class EntityAlreadyExistsException extends RuntimeException {
//Creato da gpt
    private static final long serialVersionUID = 1L;

    public EntityAlreadyExistsException(String message) {
        super(message);
    }
    
    public EntityAlreadyExistsException(String entityName, String fieldName, Object fieldValue) {
        super(String.format("%s con %s: '%s' esiste già", entityName, fieldName, fieldValue));
    }


}
