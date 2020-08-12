package com.paypal.stock.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paypal.stock.builder.ResponseBuilder;
import com.paypal.stock.entity.Stock;
import com.paypal.stock.response.StockResponse;
import com.paypal.stock.service.StockService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api")
public class StockController {


	@Autowired
	private StockService stockService;
/**
 * Retrieves stocks stored in DB
 * @return ResponseEntity<StockResponse>
 */
	@GetMapping("/displayStocks")
	public ResponseEntity<StockResponse> getAllStocks() {
		log.info("Retrieving stock");
		ResponseEntity<StockResponse> response = null;
		try {
			response = stockService.retrieveStocks();
		}
		catch(Exception e)
		{
			response = ResponseBuilder.buildErrorResponse("No stocks available",HttpStatus.NOT_FOUND);
		}

		return response;

	}
	/**
	 * create stocks  in DB
	 * @return ResponseEntity<StockResponse>
	 */
	@PostMapping("/createStock")
	public ResponseEntity<StockResponse> createStock(@RequestBody @Valid Stock stock) {
		log.info("Creating stock");
		ResponseEntity<StockResponse> response = null;
		try {
			
			response = stockService.createStock(stock);

		} catch (Exception e) {
			response = ResponseBuilder.buildErrorResponse("Stock cannot be created", HttpStatus.CONFLICT);
		}

		return response;

	}
	/**
	 * update particular stock stored in DB
	 * @return ResponseEntity<StockResponse>
	 */
	@PutMapping("/updateStock")
	public ResponseEntity<StockResponse> updateStock(@RequestBody @Valid Stock stock) {
		ResponseEntity<StockResponse> response = null;
		try {
			log.info("Updating Stock");
			response = stockService.updateStock(stock);
		}
		catch(Exception e) {
			response = ResponseBuilder.buildErrorResponse("Stock cannot be updated",  HttpStatus.NOT_FOUND);
		}

		return response;
}
}