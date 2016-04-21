CREATE TABLE product
(
  movieID   CHAR(15)     PRIMARY KEY NOT NULL,
  title  VARCHAR(100)   NOT NULL,
  studio VARCHAR(20)    NOT NULL,
  year   year           NOT NULL,
  price  DECIMAL(9,2)   DEFAULT NULL,
  image  VARCHAR(20)    

);

INSERT INTO product (movieID,title,studio,year,price,image)
VALUES (1, 'Titanic', 'Fox', 1999, 20, 'titanic.jpg' );

INSERT INTO product (movieID,title,studio,year,price,image)
VALUES (2, 'Spiderman', 'Paramount', 2005, 14.99, 'spiderman.jpg' );

INSERT INTO product (movieID,title,studio,year,price,image)
VALUES (3, 'Rushmore', 'Fox', 2006, 14.99, 'rushmore.png' );

INSERT INTO product (movieID,title,studio,year,price,image)
VALUES (4, 'Fargo', 'Ea Games', 2001, 9.99, 'fargo.jpg' );

INSERT INTO product (movieID,title,studio,year,price,image)
VALUES (5, 'Argo', 'Universal', 2013, 9.99, 'argo.jpg' );

INSERT INTO product (movieID,title,studio,year,price,image)
VALUES (6, 'Batman', 'Lions gate', 2006, 9.99, 'batman.jpg' );

INSERT INTO product (movieID,title,studio,year,price,image)
VALUES (7, 'Valkyrie', 'Fox', 2005, 19.99, 'valkyrie.jpg' );

INSERT INTO product (movieID,title,studio,year,price,image)
VALUES (8, 'Tog Gun', 'Paramount', 1989, 9.99, 'topgun.jpg' );

INSERT INTO product (movieID,title,studio,year,price,image)
VALUES (9, 'Blade', 'Universal', 2000, 14.99, 'blade.jpg' );