CREATE TABLE users
(

  user_id CHAR(15) PRIMARY KEY NOT NULL,
  username VARCHAR(30) NOT NULL,	
  password   VARCHAR(30)  NOT NULL

  
 

);


INSERT INTO users (user_id,username,password)
VALUES (1, 'Michael', '123');

INSERT INTO users (user_id,username,password)
VALUES (2, 'Frances', '000');