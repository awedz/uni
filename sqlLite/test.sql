CREATE DATABASE TEST;
USE TEST;

CREATE TABLE ServiceType (
  ServiceTypeID int PRIMARY KEY,
  serviceType nvarchar(20)
);

CREATE TABLE Region (
  RegionID int PRIMARY KEY,
  RegionName nvarchar(20)
);

CREATE TABLE Customers(
	CustomersID int PRIMARY KEY,
	firstName nvarchar(20) NOT NULL,
	lastName nvarchar(20) NOT NULL,
	age int NOT NULL,
	user_id nvarchar(9) NOT NULL
);

CREATE TABLE ServiceGivers (
  ServiceGiversID int PRIMARY KEY,
  firstName nvarchar(20) NOT NULL,
  lastName nvarchar(20) NOT NULL,
  age int,
  user_id nvarchar(9) NOT NULL
);

CREATE TABLE Service_Givers (
	ServiceID int NOT NULL,
	ServiceGiversID int NOT NULL,
	FOREIGN KEY (ServiceID) REFERENCES ServiceType(ServiceTypeID),
	FOREIGN KEY (ServiceGiversID) REFERENCES ServiceGivers(ServiceGiversID)
);

CREATE TABLE Service_Location(
  ServiceGiversID int NOT NULL,
  locationID int NOT NULL,
  FOREIGN KEY (ServiceGiversID) REFERENCES ServiceGivers(ServiceGiversID),
  FOREIGN KEY (locationID) REFERENCES Region(RegionID)
);
