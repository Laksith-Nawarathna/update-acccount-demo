CREATE TABLE IF NOT EXISTS `Account`(
                                     account_number INT PRIMARY KEY ,
                                     customer_name VARCHAR(255) NOT NULL ,
                                     username VARCHAR(50) NOT NULL ,
                                     password VARCHAR(300) NOT NULL ,
                                     balance DECIMAL NOT NULL
);