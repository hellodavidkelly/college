CREATE TABLE inventory
(
  gameID   CHAR(15)     PRIMARY KEY NOT NULL,
  title  VARCHAR(100)   NOT NULL,
  pub    VARCHAR(20)    NOT NULL,
  year   year           NOT NULL,
  price  DECIMAL(9,2)   DEFAULT NULL,
  image  VARCHAR(20)    

);

INSERT INTO inventory (gameID,title,pub,year,price,image)
VALUES (1, 'Fallout', 'Bethseda', 1999, 20, 'FALLOUT.jpg' );

INSERT INTO inventory (gameID,title,pub,year,price,image)
VALUES (2, 'Tomb Raider', 'Eidos', 1998, 10, 'tomb_raider.jpg' );

INSERT INTO inventory (gameID,title,pub,year,price,image)
VALUES (3, 'Final Fantasy', 'Square', 1989, 40, 'final_fantasy.png' );

INSERT INTO inventory (gameID,title,pub,year,price,image)
VALUES (4, 'NBA', 'Ea Games', 2014, 30, 'nba.jpg' );

INSERT INTO inventory (gameID,title,pub,year,price,image)
VALUES (5, 'Resident Evil', 'Hell Games', 2007, 39.99, 'resident_evil.jpg' );

INSERT INTO inventory (gameID,title,pub,year,price,image)
VALUES (6, 'Fifa 14', 'Ea Games', 2014, 59.99, 'fifa_14.jpg' );

INSERT INTO inventory (gameID,title,pub,year,price,image)
VALUES (7, 'Call Of Duty', 'Bethsea', 2009, 50, 'call_of_duty.jpg' );

INSERT INTO inventory (gameID,title,pub,year,price,image)
VALUES (8, 'Silent Hill', 'Hell Games', 2001, 29.99, 'silent_hill.jpg' );

INSERT INTO inventory (gameID,title,pub,year,price,image)
VALUES (9, 'Skyrim', 'Hell Games', 2014, 59.99, 'skyrim.jpg' );