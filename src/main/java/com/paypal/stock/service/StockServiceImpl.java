package com.paypal.stock.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.paypal.stock.builder.ResponseBuilder;
import com.paypal.stock.entity.Stock;
import com.paypal.stock.repository.StockRepository;
import com.paypal.stock.response.StockResponse;
import com.paypal.stock.service.StockService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("stockService")
public class StockServiceImpl implements StockService {
	
	@Autowired
	private StockRepository stockRepository;
		
	@Override
	public ResponseEntity<StockResponse>  retrieveStocks() {
		log.info("Retrieving stocks");
		List<Stock> stocks=new ArrayList<>();
		ResponseEntity<StockResponse> response=null;
		stocks= stockRepository.findAll();
		response=ResponseBuilder.buildResponse(stocks, HttpStatus.OK);
		return response;
	}


	@Override
	public ResponseEntity<StockResponse> createStock(Stock stock) {
		log.info("creating stocks");
		List<Stock> stocks=new ArrayList<>();
		ResponseEntity<StockResponse> response=null;
		stockRepository.save(stock);
		stocks= stockRepository.findAll();
		response=ResponseBuilder.buildResponse(stocks, HttpStatus.OK);
		return response;
	}


	@Override
	public ResponseEntity<StockResponse> updateStock(Stock stock) {
		log.info("updating stocks");
		List<Stock> stocks=new ArrayList<>();
		ResponseEntity<StockResponse> response=null;
		Stock stockFound=stockRepository.findOne(stock.getStockNumber());
			
		if(null!=stockFound && stock.getQuantity() > 1) {
			stockRepository.save(stock);
		}
		else if(stock.getQuantity()<=0)
		{
			deleteStock(stock.getStockNumber());
		}
		stocks= stockRepository.findAll();
		response=ResponseBuilder.buildResponse(stocks, HttpStatus.OK);
		return response;
	}
	
	@Override
	public void deleteStock(int stockNumber) {
		log.info("Deleting stocks");
		stockRepository.delete(stockNumber);
		
	}

	
}
