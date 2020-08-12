package com.paypal.stock.builder;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.paypal.stock.entity.Stock;
import com.paypal.stock.response.StockResponse;

public class ResponseBuilder {

	public static ResponseEntity<StockResponse> buildResponse(List<Stock> stocks, HttpStatus httpStatus) {

		StockResponse response = new StockResponse();
		response.setResults(stocks);
		response.setStatus("Success");

		return new ResponseEntity<>(response, httpStatus);

	}
	public static ResponseEntity<StockResponse> buildErrorResponse(String message, HttpStatus httpStatus) {

		StockResponse response = new StockResponse();
		response.setResults(null);
		response.setStatus(message);

		return new ResponseEntity<>(response, httpStatus);

	}

	
}
