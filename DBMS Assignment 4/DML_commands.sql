INSERT INTO Members (member_name, address_line1, address_line2, category)
VALUES ("Gaurav Tak", "Nehru Nagar", "Sirohi", "F");
INSERT INTO Members (member_name, address_line1, address_line2, category)
VALUES ("Shivam Lalwani", "Sindhi Colony", "Gwalior", "F");
INSERT INTO Members (member_name, address_line1, address_line2, category)
VALUES ("Neel Singhal", "Brahmpuri", "Jaipur", "S");
INSERT INTO Members (member_name, address_line1, address_line2, category)
VALUES ("Udit Saxena", "Railway Colony", "Jabalpur", "S");
INSERT INTO Members (member_name, address_line1, address_line2, category)
VALUES ("Rajat Jain", "Johri Bazar", "Jaipur", "O");
INSERT INTO Members (member_name, address_line1, address_line2, category)
VALUES ("Chetan Sharma", "Tonk Fatak", "Jaipur", "S");
INSERT INTO Members (member_name, address_line1, address_line2, category)
VALUES ("Pawan Manglani", "Tonk Fatak", "Jaipur", "P");



INSERT INTO Authors(author_name)
VALUES("Chetan Bhagat"),
("JK Rowling"),
("Fredrik Backman");


INSERT INTO Publishers( publisher_name)
VALUES("Sydney Sheldon"),
("Karl Marks"),
("London Express");

INSERT INTO Subjects(subject_name)
VALUES("Technology"),
("Philosophy"),
("Literature");

INSERT INTO Titles(title_name, publisher_id, subject_id)
VALUES
("Harry Potter", 
    (SELECT publisher_id FROM Publishers WHERE publisher_name = "Sydney Sheldon"),
    (SELECT subject_id FROM Subjects WHERE subject_name = "Literature")),
("CSS-Basics",
    (SELECT publisher_id FROM Publishers WHERE publisher_name = "London Express"),
    (SELECT subject_id FROM Subjects WHERE subject_name = "Technology")),
("DBMS Basics",
    (SELECT publisher_id FROM Publishers WHERE publisher_name = "London Express"),
    (SELECT subject_id FROM Subjects WHERE subject_name = "Technology")),
("How I met You",
    (SELECT publisher_id FROM Publishers WHERE publisher_name = "Karl Marks"),
    (SELECT subject_id FROM Subjects WHERE subject_name = "Philosophy")),
("13 Reasons why",
    (SELECT publisher_id FROM Publishers WHERE publisher_name = "Karl Marks"),
    (SELECT subject_id FROM Subjects WHERE subject_name = "Philosophy"));

INSERT INTO Books(status, purchase_date, price, title_id)
VALUES
('A', '2009-12-12', 500.0,(SELECT title_id FROM Titles WHERE title_name = "Harry Potter")),
('U', '2009-11-11', 600.0,(SELECT title_id FROM Titles WHERE title_name = "Harry Potter")),
('A', '2010-10-02', 800.0,(SELECT title_id FROM Titles WHERE title_name = "Harry Potter")),
('U', '2001-03-22', 800.0,(SELECT title_id FROM Titles WHERE title_name = "CSS-Basics")),
('A', '2009-12-12', 900.0,(SELECT title_id FROM Titles WHERE title_name = "CSS-Basics")),
('U', '2010-12-12', 750.0,(SELECT title_id FROM Titles WHERE title_name = "How I met You")),
('U', '2011-12-12', 900.0,(SELECT title_id FROM Titles WHERE title_name = "CSS-Basics")),
('A', '2012-12-12', 1000.0,(SELECT title_id FROM Titles WHERE title_name = "13 Reasons why")),
('A', '2010-11-12', 700.0,(SELECT title_id FROM Titles WHERE title_name = "DBMS Basics")),
('U', '2009-01-12', 800.0,(SELECT title_id FROM Titles WHERE title_name = "13 Reasons why")),
('A', '2009-12-12', 800.0,(SELECT title_id FROM Titles WHERE title_name = "DBMS Basics"));

INSERT INTO Title_author(author_id, title_id)
VALUES 
((SELECT author_id FROM Authors WHERE author_name = "Chetan Bhagat"),
    (SELECT title_id FROM Titles WHERE title_name = "13 Reasons why")),
((SELECT author_id FROM Authors WHERE author_name = "Fredrik Backman"),
    (SELECT title_id FROM Titles WHERE title_name = "CSS-Basics")),
((SELECT author_id FROM Authors WHERE author_name = "Chetan Bhagat"),
    (SELECT title_id FROM Titles WHERE title_name = "How I met You")),
((SELECT author_id FROM Authors WHERE author_name = "Fredrik Backman"),
    (SELECT title_id FROM Titles WHERE title_name = "DBMS Basics")),
((SELECT author_id FROM Authors WHERE author_name = "JK Rowling"),
    (SELECT title_id FROM Titles WHERE title_name = "Harry Potter"));

INSERT INTO Book_issue(accession_no, member_id)
VALUES 
(8002,(SELECT member_id FROM Members WHERE member_name = "Shivam Lalwani")),
(8004,(SELECT member_id FROM Members WHERE member_name = "Neel Singhal")),
(8006,(SELECT member_id FROM Members WHERE member_name = "Gaurav Tak")),
(8007,(SELECT member_id FROM Members WHERE member_name = "Rajat Jain")),
(8011,(SELECT member_id FROM Members WHERE member_name = "Gaurav Tak"));

SET SQL_SAFE_UPDATES = 0;

UPDATE book_issue SET due_date = NOW() + INTERVAL 15 DAY where due_date is null; 


INSERT INTO Book_return( issue_date,return_date,accession_no, member_id)
VALUES 
('2017-08-21','2017-09-04',8001,(SELECT member_id FROM Members WHERE member_name = "Shivam Lalwani")),
('2017-08-28','2017-08-21',8003,(SELECT member_id FROM Members WHERE member_name = "Rajat Jain")),
('2017-07-30','2017-08-28',8005,(SELECT member_id FROM Members WHERE member_name = "Gaurav Tak")),
('2017-08-01','2017-08-28',8008,(SELECT member_id FROM Members WHERE member_name = "Neel Singhal")),
('2017-08-28','2017-09-02',8009,(SELECT member_id FROM Members WHERE member_name = "Gaurav Tak"));

SET SQL_SAFE_UPDATES=0;

UPDATE Members SET address_line2 = "Jaipur";

UPDATE Members SET address_line1 = "EPIP, Sitapura" where category = "F";

DELETE FROM Publishers;

SET @name = 'London Express' , @id = 303;
INSERT INTO Publishers(publisher_id,publisher_name)
    values(@id,@name);
    
SET @name = 'Sydney Sheldon' , @id = 301;
INSERT INTO Publishers(publisher_id,publisher_name)
    values(@id,@name);
    
SET @name = 'Karl Marks' , @id = 302;
INSERT INTO Publishers(publisher_id,publisher_name)
    values(@id,@name);

/* repopulating table data for all child tables of publisher*/

ALTER TABLE Titles AUTO_INCREMENT = 501;

INSERT INTO Titles(title_name, publisher_id, subject_id)
VALUES("Harry Potter", 
    (SELECT publisher_id FROM Publishers WHERE publisher_name = "Sydney Sheldon"),
    (SELECT subject_id FROM Subjects WHERE subject_name = "Literature")),
("CSS-Basics",
    (SELECT publisher_id FROM Publishers WHERE publisher_name = "London Express"),
    (SELECT subject_id FROM Subjects WHERE subject_name = "Technology")),
("DBMS Basics",
    (SELECT publisher_id FROM Publishers WHERE publisher_name = "London Express"),
    (SELECT subject_id FROM Subjects WHERE subject_name = "Technology")),
("How I met You",
    (SELECT publisher_id FROM Publishers WHERE publisher_name = "Karl Marks"),
    (SELECT subject_id FROM Subjects WHERE subject_name = "Philosophy")),
("13 Reasons why",
    (SELECT publisher_id FROM Publishers WHERE publisher_name = "Karl Marks"),
    (SELECT subject_id FROM Subjects WHERE subject_name = "Philosophy"));

ALTER TABLE Books AUTO_INCREMENT = 8001;

INSERT INTO Books(status, purchase_date, price, title_id)
VALUES
('A', '2009-12-12', 500.0,(SELECT title_id FROM Titles WHERE title_name = "Harry Potter")),
('U', '2009-11-11', 600.0,(SELECT title_id FROM Titles WHERE title_name = "Harry Potter")),
('A', '2010-10-02', 800.0,(SELECT title_id FROM Titles WHERE title_name = "Harry Potter")),
('U', '2001-03-22', 800.0,(SELECT title_id FROM Titles WHERE title_name = "CSS-Basics")),
('A', '2009-12-12', 900.0,(SELECT title_id FROM Titles WHERE title_name = "CSS-Basics")),
('U', '2010-12-12', 750.0,(SELECT title_id FROM Titles WHERE title_name = "How I met You")),
('U', '2011-12-12', 900.0,(SELECT title_id FROM Titles WHERE title_name = "CSS-Basics")),
('A', '2012-12-12', 1000.0,(SELECT title_id FROM Titles WHERE title_name = "13 Reasons why")),
('A', '2010-11-12', 700.0,(SELECT title_id FROM Titles WHERE title_name = "DBMS Basics")),
('U', '2009-01-12', 800.0,(SELECT title_id FROM Titles WHERE title_name = "13 Reasons why")),
('A', '2009-12-12', 800.0,(SELECT title_id FROM Titles WHERE title_name = "DBMS Basics"));

INSERT INTO Title_author(author_id, title_id)
VALUES ((SELECT author_id FROM Authors WHERE author_name = "Chetan Bhagat"),
    (SELECT title_id FROM Titles WHERE title_name = "13 Reasons why")),
((SELECT author_id FROM Authors WHERE author_name = "Fredrik Backman"),
    (SELECT title_id FROM Titles WHERE title_name = "CSS-Basics")),
((SELECT author_id FROM Authors WHERE author_name = "Chetan Bhagat"),
    (SELECT title_id FROM Titles WHERE title_name = "How I met You")),
((SELECT author_id FROM Authors WHERE author_name = "Fredrik Backman"),
    (SELECT title_id FROM Titles WHERE title_name = "DBMS Basics")),
((SELECT author_id FROM Authors WHERE author_name = "JK Rowling"),
    (SELECT title_id FROM Titles WHERE title_name = "Harry Potter"));



INSERT INTO Book_issue(accession_no, member_id)
VALUES 
(8002,(SELECT member_id FROM Members WHERE member_name = "Shivam Lalwani")),
(8004,(SELECT member_id FROM Members WHERE member_name = "Neel Singhal")),
(8006,(SELECT member_id FROM Members WHERE member_name = "Gaurav Tak")),
(8007,(SELECT member_id FROM Members WHERE member_name = "Rajat Jain")),
(8011,(SELECT member_id FROM Members WHERE member_name = "Gaurav Tak"));

-- insert queries for question demand --
INSERT INTO book_issue 
(issue_date, accession_no, member_id) VALUES ('2017-05-05 16:22:11', 8001, 101);

INSERT INTO book_issue 
(issue_date, accession_no, member_id) VALUES ('2017-09-05 16:22:11', 8011, 104);


UPDATE book_issue SET due_date = NOW() + INTERVAL 15 DAY where due_date is null; 


INSERT INTO Book_return( issue_date,return_date,accession_no, member_id)
VALUES 
('2017-08-21','2017-09-04',8001,(SELECT member_id FROM Members WHERE member_name = "Shivam Lalwani")),
('2017-08-28','2017-08-21',8003,(SELECT member_id FROM Members WHERE member_name = "Rajat Jain")),
('2017-07-30','2017-08-28',8005,(SELECT member_id FROM Members WHERE member_name = "Gaurav Tak")),
('2017-08-01','2017-08-28',8008,(SELECT member_id FROM Members WHERE member_name = "Neel Singhal")),
('2017-08-28','2017-09-02',8009,(SELECT member_id FROM Members WHERE member_name = "Gaurav Tak"));
