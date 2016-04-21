CREATE TABLE cart
(
  
  gameID  INT(250)   PRIMARY KEY NOT NULL,
  session_id   CHAR(30)     NOT NULL,
  title    VARCHAR(20)    NOT NULL,
  price  DECIMAL(9,2)   DEFAULT NULL,
  quantity INT DEFAULT 1
 

);