

--
-- Database: `web_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--
CREATE DATABASE IF NOT EXISTS web_db;
USE web_db;

DROP TABLE IF EXISTS `customers`;
CREATE TABLE IF NOT EXISTS `customers` (
  customerId int NOT NULL AUTO_INCREMENT,
  firstname varchar (20) NOT NULL, 
  lastname varchar(20) NOT NULL,
  email varchar(20) NOT NULL,
  weight int NOT NULL,
  PRIMARY KEY (customerId)
 
);

