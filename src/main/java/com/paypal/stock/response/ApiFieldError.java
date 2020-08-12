package com.paypal.stock.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ApiFieldError {
	
	   private String field;
	    private String code;
	    private Object rejectedValue;

}
