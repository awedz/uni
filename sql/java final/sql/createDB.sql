CREATE DATABASE javaProject;
USE javaProject;
CREATE TABLE Apartment(
	ID INT NOT NULL AUTO_INCREMENT,
    prince INT,
    PRIMARY KEY(ID)
);
CREATE TABLE Payment(
	ID int NOT NULL AUTO_INCREMENT,
	apartmentID INT,
	paymentSum INT,
    isPaid BOOL,
	dueDate INT,
    PRIMARY KEY(ID)
);
CREATE TABLE Tanent(
	ID INT NOT NULL AUTO_INCREMENT,
    firstName VARCHAR(255),
    lastName VARCHAR(255),
    userID VARCHAR(255),
    apartmentID INT,
	seniority INT,
	isCommotte BOOL,
	monthlyWage INT,
	pswd VARCHAR(255),
    PRIMARY KEY(ID),
    FOREIGN KEY(apartmentID) REFERENCES Apartment(ID)
);
CREATE TABLE Apartment_Tannent(
	ID INT NOT NULL AUTO_INCREMENT,
    tanentID INT,
    apartmentID INT,
    FOREIGN KEY(tanentID) REFERENCES Tanent(ID),
	FOREIGN KEY(apartmentID) REFERENCES Apartment(ID),
    PRIMARY KEY(ID)
);


