

SELECT * FROM Members WHERE category = (SELECT category FROM Members WHERE member_name = "Shivam Lalwani");

SELECT member_id, issue_date, due_date FROM Book_issue
where member_id NOT IN (SELECT member_id FROM Book_return WHERE Book_issue.member_id = Book_return.member_id);

SELECT Book_issue.member_id, m.member_name, issue_date, due_date, Titles.title_name FROM Book_issue
INNER JOIN Members m ON
m.member_id = Book_issue.member_id
INNER JOIN Books ON
Book_issue.accession_no = Books.accession_no
INNER JOIN Titles ON
Books.title_id = Titles.title_id  
where not exists (SELECT member_id FROM Book_return WHERE Book_issue.member_id = Book_return.member_id);

SELECT * FROM Books WHERE price = (SELECT MAX(price) FROM Books)  AND purchase_date IS NOT NULL;

SELECT * FROM Books ORDER BY price DESC LIMIT 2,1;

SELECT accession_no, MAX(price) AS Second_Max_Price FROM Books WHERE price < (SELECT MAX(price) FROM Books);

CREATE VIEW Show_details AS

SELECT m.member_name, bi.issue_date, bi.due_date, bi.accession_no FROM Members m
INNER JOIN Book_issue bi ON
m.member_id = bi.member_id;

Select * FROM Show_details;


SELECT member_id, member_name, CASE WHEN category = "S" THEN 'Student' WHEN category = "F" THEN 'Faculty' 
ELSE 'Others' END AS re_type_text
FROM Members; 


CREATE VIEW Show_Full_details AS

SELECT s.subject_name, t.title_name, m.member_name, m.category,bi.member_id, bi.issue_date, bi.due_date, bi.accession_no, br.return_date 
FROM Book_issue bi
LEFT OUTER JOIN Book_return br ON
bi.accession_no = br.accession_no AND
bi.member_id = br.member_id
RIGHT OUTER JOIN Members m ON
m.member_id = bi.member_id
INNER JOIN Books b ON
bi.accession_no = b.accession_no
INNER JOIN Titles t ON
b.title_id = t.title_id 
INNER JOIN Subjects s ON
t.subject_id = s.subject_id;

Select * FROM Show_Full_details;

/*SELECT bi.member_id, bi.accession_no, bi.issue_date, br.return_date, m.member_name FROM Book_issue bi
LEFT JOIN Book_return br ON
bi.accession_no = br.accession_no
RIGHT OUTER JOIN Members m ON
m.member_id = bi.member_id;*/