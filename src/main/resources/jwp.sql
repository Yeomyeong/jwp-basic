DROP TABLE IF EXISTS USERS;

CREATE TABLE USERS ( 
	userId          varchar(12)		NOT NULL, 
	password		varchar(12)		NOT NULL,
	name			varchar(20)		NOT NULL,
	email			varchar(50),	
  	
	PRIMARY KEY               (userId)
);

INSERT INTO USERS VALUES('admin', 'password', '자바지기', 'admin@slipp.net');
INSERT INTO USERS VALUES('wymstar', 'pass1111', '자바와나', 'wymstar@slipp.net');