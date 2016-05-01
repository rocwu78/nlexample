create table Borrower (
    id int not null,
    name varchar(100) not null,
    phone varchar(20),
    email varchar(100),
    version int not null,
    primary key (id)
);

create table Book (
	id int not null,
	title varchar(200) not null,
	author varchar(100) not null,
	ISBN varchar(20) not null,
	version int not null,
	primary key(id)
);

create table BorrowRecord (
	id int not null,
	borrowerID int not null,
	bookID int not null,
	borrowDate date not null,
	returned boolean,
	version int not null,
	primary key(id)
);

insert into Borrower (id, name, phone, email, version) values (1, 'Xavier Winston', '0256785678','xw@lbexample.com',0);
insert into Borrower (id, name, phone, email, version) values (2, 'Cheyenne Dick', '0256785666','cd@lbexample.com',0);
insert into Borrower (id, name, phone, email, version) values (3, 'Kev Towner', '0256782345','kt@lbexample.com',0);
insert into Borrower (id, name, phone, email, version) values (4, 'Alec Christinsen', '0256785432','ac@lbexample.com',0);
insert into Borrower (id, name, phone, email, version) values (5, 'Jaiden Woodcock', '0256787777','jw@lbexample.com',0);

insert into Book (id, title, author, ISBN, version)  values (1, 'The Life-Changing Magic of Tidying Up', 'Marie Kondo','978-1607747307',0 );
insert into Book (id, title, author, ISBN, version)  values (2, 'StrengthsFinder 2.0', 'Tom Rath','978-1595620156',0 );
insert into Book (id, title, author, ISBN, version)  values (3, 'Harry Potter and the Cursed Child', 'J.K.Rowling','978-1338099133',0 );
insert into Book (id, title, author, ISBN, version)  values (4, 'The Very Hungry Caterpillar', 'Eric Carle','978-0399226908' ,0);
insert into Book (id, title, author, ISBN, version)  values (5, 'Oh, The Places You''ll Go!', 'Dr. Seuss','978-0679805274' ,0);
insert into Book (id, title, author, ISBN, version)  values (6, 'The C Programming Language', 'Brian W. Kernighan','978-0131103627',0 );
insert into Book (id, title, author, ISBN, version)  values (7, 'Design Patterns: Elements of Reusable Object-Oriented Software', 'Erich Gamma','978-0201633610',0 );

insert into BorrowRecord (id, borrowerID, bookID, borrowDate, returned, version) values (1, 1, 1, '2016-01-01',false,0);
insert into BorrowRecord (id, borrowerID, bookID, borrowDate, returned, version) values (2, 2, 2, '2016-01-01',false,0);
insert into BorrowRecord (id, borrowerID, bookID, borrowDate, returned, version) values (3, 3, 3, '2016-01-01',false,0);
insert into BorrowRecord (id, borrowerID, bookID, borrowDate, returned, version) values (4, 4, 4, '2016-01-01',false,0);
insert into BorrowRecord (id, borrowerID, bookID, borrowDate, returned, version) values (5, 4, 5, '2016-01-01',false,0);
insert into BorrowRecord (id, borrowerID, bookID, borrowDate, returned, version) values (6, 5, 6, '2016-01-01',false,0);
insert into BorrowRecord (id, borrowerID, bookID, borrowDate, returned, version) values (7, 5, 7, '2016-01-01',true,0);





