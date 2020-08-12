package com.paypal.stock.response;

import java.util.List;

import org.springframework.stereotype.Component;

import com.paypal.stock.entity.Stock;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class StockResponse {

	
	 private String status;
	  
	private List<Stock> results; 
	 	
}
