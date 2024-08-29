package com.itschool.my_blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND) //Annotation that will couse Spring boot to respond with a specific HTTP status code when this exception is thrown
public class ResourceNotFoundException extends RuntimeException {

    private final String resourceName;

    private final String fieldName;

    private final Long fieldValue;

    public ResourceNotFoundException(String resourceName, String fieldName, Long fieldValue) {
        super(String.format("% not found with % : '%'", resourceName, fieldName, fieldValue)); //Build a string with the exception message
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Long getFieldValue() {
        return fieldValue;
    }
}
