package com.paypal.stock.entity;






import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "StockInventory")
@Entity
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Min(value = 1)
	@Column(name = "stock_number")
	private Integer stockNumber;
	
	@NotBlank(message = "StockName is mandatory")
	@Column(name = "stock_name")
	private String stockName;
	
	@Min(value = 1)
	@Column(name = "purchasing_price")
	private Integer purchasingPrice;
	
	@Column(name = "quantity")
	private Integer quantity;
	
	@Column(name = "purchasing_date")
	private Date purchasingDate;
	
	
	
	
}
