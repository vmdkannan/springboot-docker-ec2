package com.vk.org.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;


@ControllerAdvice
public class ExceptionHandlingController {

    @ExceptionHandler(ABCOrgException.class)
    public ResponseEntity<ExceptionResponse> resourceNotFound(ABCOrgException ex) {
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorCode(""+HttpStatus.BAD_REQUEST);
        response.setErrorMessage(ex.getMessage());

        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ExceptionResponse> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
    	ExceptionResponse response = new ExceptionResponse();
        String name = ex.getName();
        String type = ex.getRequiredType().getSimpleName();
        Object value = ex.getValue();
        String message = String.format("ID should be a number.", 
                                       name, type, value);
        
        response.setErrorMessage(message);
        response.setErrorCode(""+HttpStatus.BAD_REQUEST);

        System.out.println(message);
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(HttpMessageNotWritableException.class)
    public ResponseEntity<ExceptionResponse> handleTypeMismatch(HttpMessageNotWritableException ex) {
    	ExceptionResponse response = new ExceptionResponse();
        String message = String.format("Requested ID not found.");
        response.setErrorMessage(message);
        response.setErrorCode(""+HttpStatus.BAD_REQUEST);

        System.out.println(message);
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<ExceptionResponse> idNotFound(IdNotFoundException ex) {
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorMessage(ex.getMessage());
        response.setErrorCode(""+HttpStatus.BAD_REQUEST);

        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(EntityExistsException.class)
    public ResponseEntity<ExceptionResponse> entityExists(EntityExistsException ex) {
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorMessage(ex.getMessage());
        response.setErrorCode(""+HttpStatus.BAD_REQUEST);

        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
    }
}
