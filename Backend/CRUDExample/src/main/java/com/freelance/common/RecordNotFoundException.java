package com.freelance.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
 
@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecordNotFoundException extends RuntimeException
{
    public RecordNotFoundException(String exception) {
        super(exception);
    }
    public RecordNotFoundException(String resourceName, String fieldName, Object fieldValue) {
		super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
	}
}