use Customer;
CREATE TABLE  Customer(Cust_ID bigint Primary Key Auto_Increment,First_Name varchar(100),Last_Name varchar(100),UID varchar(100),Password varchar(10),Email varchar(100),Address varchar(100),State varchar(100),City varchar(100),Zipcode bigint,Time_Of_Account_Update timestamp default CURRENT_TIMESTAMP);
