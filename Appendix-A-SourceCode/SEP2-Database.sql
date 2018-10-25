create schema Bank

CREATE TABLE Bank.Accounts (
	fName varchar(10),
	lName varchar(20),
	AccNo int not null primary key,
	phoneNo varchar(255),
	email varchar(255),
	balance float,
	nick varchar(4)
	password varcha(10)
);

create table Bank.Transaction(
	AccNo int,
	Date date,
	senderAccNo int not null,
	recieverAccNo int not null,
	transactionAmount float,
	transactionNo serial primary key ,
	FOREIGN KEY (AccNo) REFERENCES Bank.Accounts(AccNo)
); 

//Creating accounts
INSERT INTO BANK.accounts
VALUES ('Patrick','Ihnat',50607090,'+4560905522','skol@gmail.com', 100,'paih');

INSERT INTO BANK.accounts
VALUES ('Dan','Molnar',60507090,'+4560904411','skol2@gmail.com', 150,'damo');

INSERT INTO BANK.accounts
VALUES ('Zahari','Dzehelpov',40207090,'+4560906622','skol3@gmail.com', 200,'zadz');

INSERT INTO BANK.accounts
VALUES ('Nikola','Vasilev',30607090,'+4560903322','skol4@gmail.com', 120,'niva');

INSERT INTO BANK.accounts
VALUES ('Bohzidar','Nedyalkov',50307090,'+4560908899','skol5@gmail.com', 100,'bone');


//SOME TRANSACTIONS
INSERT INTO BANK.transaction
VALUES (50607090,'2017-11-29',50607090,60507090,20);

INSERT INTO BANK.transaction
VALUES (60507090,'2017-11-29',60507090,50607090,20);

INSERT INTO BANK.transaction
VALUES (40207090,'2017-11-29',40207090,30607090,20);

INSERT INTO BANK.transaction
VALUES (30607090,'2017-11-29',30607090,40207090,20);

INSERT INTO BANK.transaction
VALUES (50307090,'2017-11-29',50307090,30607090,20);

INSERT INTO BANK.transaction
VALUES (30607090,'2017-11-29',30607090,50307090,20);
