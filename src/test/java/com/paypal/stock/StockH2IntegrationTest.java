package com.paypal.stock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.paypal.stock.StockApplication;
import com.paypal.stock.entity.Stock;
import com.paypal.stock.repository.StockRepository;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = StockApplication.class)
public class StockH2IntegrationTest {

    @Autowired
    private StockRepository stockRepository;

    @Test
    public void contextLoads() { }

    @Test
    public void givenStock_thenCreateNewStock() {
        Stock stock = new Stock();
        stock.setStockNumber(3);
        stock.setStockName("D");
        stock.setQuantity(3);
        stock.setPurchasingPrice(500);
        stock.setPurchasingDate(null);
        
        Stock stock1 = new Stock();
        stock1.setStockNumber(4);
        stock1.setStockName("D");
        stock1.setQuantity(3);
        stock1.setPurchasingPrice(500);
        stock1.setPurchasingDate(null);
        stockRepository.save(stock);
        stockRepository.save(stock1);
        List<Stock> stocks = (List<Stock>) stockRepository.findAll();
        assertFalse(stocks.isEmpty());
       
       
    }

}