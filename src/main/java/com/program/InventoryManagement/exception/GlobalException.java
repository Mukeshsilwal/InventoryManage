package com.program.InventoryManagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> responseResponseEntity(ResourceNotFoundException ex){
        String msg=ex.getMessage();
        ApiResponse apiResponse=new ApiResponse(msg,HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(ResourceEmpty.class)
    public ResponseEntity<ApiResponse> responseEntity(ResourceEmpty ex){
        String msg=ex.getMessage();
        ApiResponse apiResponse=new ApiResponse(msg,HttpStatus.IM_USED);
        return new ResponseEntity<>(apiResponse,HttpStatus.NOT_FOUND);
    }

}
