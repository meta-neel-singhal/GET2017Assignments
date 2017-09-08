CREATE DATABASE Library_Information_DB;
USE Library_Information_DB;

Create TABLE Members(
 member_id int AUTO_INCREMENT,
 member_name varchar(45),
 address_line1 varchar(45),
 address_line2 varchar(45),
 category varchar(10),
 PRIMARY KEY (member_id)
)AUTO_INCREMENT = 101;

Create TABLE Authors(
 author_id int AUTO_INCREMENT PRIMARY KEY,
 author_name varchar(60)
)AUTO_INCREMENT = 201;

Create TABLE Publishers(
 publisher_id int AUTO_INCREMENT PRIMARY KEY,
 publisher_name varchar(60)
)AUTO_INCREMENT = 301;

Create TABLE Subjects(
 subject_id int AUTO_INCREMENT PRIMARY KEY,
 subject_name varchar(60)
)AUTO_INCREMENT = 401;

Create TABLE Titles(
 title_id int AUTO_INCREMENT PRIMARY KEY,
 title_name varchar(60),
 publisher_id int(10),
 subject_id int(10),
 CONSTRAINT fk_publisher_id FOREIGN KEY (publisher_id) REFERENCES Publishers(publisher_id)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
 CONSTRAINT fk_subject_id FOREIGN KEY (subject_id) REFERENCES Subjects(subject_id)
  ON DELETE CASCADE
  ON UPDATE CASCADE
)AUTO_INCREMENT = 501;

CREATE Table Books(
 accession_no int PRIMARY KEY AUTO_INCREMENT ,
 status char(1),
 purchase_date date,
 price float,
 title_id int(10),
 CONSTRAINT fk_title_id FOREIGN KEY (title_id) REFERENCES Titles(title_id)
  ON DELETE CASCADE
  ON UPDATE CASCADE
)AUTO_INCREMENT = 8001;

Create TABLE Title_author(
 title_id int,
 author_id int,
 PRIMARY KEY (title_id, author_id),
 CONSTRAINT fk_title_id_in_title_author FOREIGN KEY (title_id) REFERENCES Titles(title_id)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
 CONSTRAINT fk_author_id_in_title_author FOREIGN KEY (author_id) REFERENCES Authors(author_id)
  ON DELETE CASCADE
  ON UPDATE CASCADE
);

Create TABLE Book_issue(
 issue_date date,
 due_date date,
 accession_no int,
 member_id int,
 PRIMARY KEY (issue_date, accession_no, member_id),
 CONSTRAINT fk_accession_no_in_book_issue FOREIGN KEY (accession_no) REFERENCES Books(accession_no)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
 CONSTRAINT fk_member_id_no_in_book_issue FOREIGN KEY (member_id) REFERENCES Members(member_id)
  ON DELETE CASCADE
  ON UPDATE CASCADE
);

Create TABLE Book_return(
 issue_date date,
 return_date date,
 accession_no int,
 member_id int,
 PRIMARY KEY (return_date, accession_no, member_id),
 CONSTRAINT fk_accession_no_in_book_return FOREIGN KEY (accession_no) REFERENCES Books(accession_no)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
 CONSTRAINT fk_member_id_no_in_book_return FOREIGN KEY (member_id) REFERENCES Members(member_id)
  ON DELETE CASCADE
  ON UPDATE CASCADE
);

ALTER TABLE Book_issue 
MODIFY Column issue_date TIMESTAMP DEFAULT NOW();


DELIMITER $$
CREATE TRIGGER Due_Date_Trigger 
BEFORE INSERT ON Book_issue  
FOR EACH ROW 
BEGIN
        SET New.due_date = DATE_ADD(NEW.issue_date , INTERVAl 15 DAY);
END;
$$
DELIMITER ;

/*
DELIMITER $$
CREATE TRIGGER Due_Date_NULL_Trigger 
AFTER INSERT ON Book_issue  
FOR EACH ROW 
BEGIN
UPDATE book_issue SET due_date = NOW() + INTERVAL 15 DAY where due_date is null; 
END;
$$
DELIMITER ;
*/

ALTER TABLE Book_issue 
 DROP FOREIGN KEY fk_member_id_no_in_book_issue;
 
ALTER TABLE Book_return 
 DROP FOREIGN KEY fk_member_id_no_in_book_return;
 
DROP TABLE Members;

Create TABLE Members(
 member_id int AUTO_INCREMENT,
 member_name varchar(45),
 address_line1 varchar(45),
 address_line2 varchar(45),
 category varchar(10),
 PRIMARY KEY (member_id)
)AUTO_INCREMENT = 101;

ALTER TABLE Book_issue
 ADD Constraint fk_member_id_no_in_book_issue FOREIGN KEY (member_id) REFERENCES Members(member_id) 
 ON DELETE CASCADE
 ON UPDATE CASCADE;
 
ALTER TABLE Book_return
 ADD Constraint fk_member_id_no_in_book_return FOREIGN KEY (member_id) REFERENCES Members(member_id)
 ON DELETE CASCADE
 ON UPDATE CASCADE; 