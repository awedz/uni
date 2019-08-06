#DROP DATABASE house;
CREATE database house;
use house;
CREATE TABLE Apartment(
	ID int auto_increment primary key,
    MonthlyPayment int not null
);

CREATE TABLE Committee(
	ID int auto_increment primary key,
    FirstName nvarchar(20) not null,
    LastName nvarchar(20) not null,
    PersonID nvarchar(20) not null,
	UserName nvarchar(20) unique not null,
    UserPassword nvarchar(20) not null
);

CREATE TABLE Tenants (
	ID int auto_increment primary key,
    FirstName nvarchar(20) not null,
    LastName nvarchar(20) not null,
    PersonID nvarchar(20) not null,
    ApartmentNumber int not null,
    UserName nvarchar(20) unique not null,
    UserPassword nvarchar(20) not null,
	foreign key (ApartmentNumber) references Apartment(ID)
);

CREATE TABLE Payments(
		ID int auto_increment primary key,
		ApartmentNumber int not null,
        MonthNum int not null,
        AmountPayed int not null default 0
);

