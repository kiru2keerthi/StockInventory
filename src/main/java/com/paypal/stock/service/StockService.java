package com.paypal.stock.service;

import org.springframework.http.ResponseEntity;

import com.paypal.stock.entity.Stock;
import com.paypal.stock.response.StockResponse;




public interface StockService {
	
	public ResponseEntity<StockResponse> retrieveStocks();
	
	public ResponseEntity<StockResponse> createStock(Stock stock);
	
	public ResponseEntity<StockResponse> updateStock(Stock stock);
	
	public void deleteStock(int stockNumber);
	
	
	}
