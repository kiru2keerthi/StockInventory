CREATE TABLE IF NOT EXISTS Stock_Inventory(
  stock_number INT AUTO_INCREMENT  PRIMARY KEY,
  stock_name VARCHAR(250) NOT NULL,
  purchasing_price INT NOT NULL,
  quantity INT NOT NULL,
  purchasing_date DATE  DEFAULT NULL
 );

insert into Stock_Inventory(stock_number,stock_name,purchasing_price,quantity,purchasing_date)
values(1,'A',500,2,NULL);
insert into Stock_Inventory(stock_number,stock_name,purchasing_price,quantity,purchasing_date)
values(2,'B',100,3,NULL);