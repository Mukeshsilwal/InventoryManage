package com.program.InventoryManagement.exception;

public class ResourceEmpty extends RuntimeException{
    String resourceName;
    String fieldName;

    public ResourceEmpty(String resourceName, String fieldName) {
        super(String.format(resourceName,fieldName));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
    }
}
