package com.paypal.stock.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paypal.stock.entity.Stock;



@Repository("stockRepository")
@Transactional
public interface StockRepository extends JpaRepository<Stock, Integer> {
	
	
}
