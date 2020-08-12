package com.paypal.stock.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.paypal.stock.response.ApiFieldError;

@ControllerAdvice
	public class ApiFieldErrorException extends ResponseEntityExceptionHandler {
	    @Override
	    protected ResponseEntity<Object> handleMethodArgumentNotValid(
	            MethodArgumentNotValidException ex,
	            HttpHeaders headers, 
	            HttpStatus status,
	            WebRequest request
	    ) {
	        BindingResult bindingResult = ex
	                .getBindingResult();

	        List<ApiFieldError> apiFieldErrors = bindingResult
	                .getFieldErrors()
	                .stream()
	                .map(fieldError -> new ApiFieldError(
	                        fieldError.getField(),
	                        fieldError.getCode(),
	                        fieldError.getRejectedValue())
	                )
	                .collect(Collectors.toList());
	        return new ResponseEntity<>(apiFieldErrors, HttpStatus.UNPROCESSABLE_ENTITY);

}
}
