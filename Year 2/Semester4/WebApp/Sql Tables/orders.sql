CREATE TABLE orders
(
  order_id VARCHAR(29) NOT NULL,
  customer_id VARCHAR(30) NOT NULL,	
  session_id   CHAR(30)     NOT NULL,
  first_name CHAR(30) NOT NULL,
  surname CHAR(30) NOT NULL,
  address VARCHAR(30) NOT NULL,
  delivery_address VARCHAR(30) NOT NULL,
  title    VARCHAR(20)    NOT NULL,
  subtotal  DECIMAL(9,2)   DEFAULT NULL,
  credit_card VARCHAR (20)	NOT NULL
  
 

);